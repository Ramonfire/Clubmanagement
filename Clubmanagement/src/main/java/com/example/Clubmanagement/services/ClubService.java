package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.*;
import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.reunion;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClubService {

    private final ClubRepo clubRepo;
    private final MemberRepo memberRepo;
    private final RpedaRepo rpedaRepo;
    private final AccountRepo accountRepo;
    private final ReunionRepo reunionRepo;


    public List<Club> getAllActiveClub(int pagenum,int size){
        org.springframework.data.domain.Pageable pageable=  PageRequest.of(pagenum,size);
        Page<Club> page=this.clubRepo.findAllByEtat(Boolean.TRUE,pageable);

        List<Club> clubs =  Arrays.asList(page.getContent().toArray(new Club[0]));
        return clubs;

    }



    public  List<Club> getAllClubs(boolean etat,int pagenum,int size){
        org.springframework.data.domain.Pageable pageable=  PageRequest.of(pagenum,size);
        Page<Club> page= this.clubRepo.findAllByEtat(etat,pageable);
        List<Club> clubs =Arrays.asList(page.getContent().toArray(new Club[0]));
        return clubs;
    }


    public Club getclub(Long id) {
        return  this.clubRepo.findByIdc(id);
    }
//get a students Club list
    public  List<Club> GetMembersClub(Etudiant s,int pagenum,int size) {
        org.springframework.data.domain.Pageable pageable=  PageRequest.of(pagenum,size);
        Page<Club> page=this.clubRepo.findAllByStudents(s,pageable);
        List<Club> clubs =Arrays.asList(page.getContent().toArray(new Club[0]));
        return clubs;

    }

    public Long clubcount(){
        return clubRepo.count();
    }


    public String saveclub(Club club) {
        String s="error";
       Club x= this.clubRepo.save(club);
       if(x.getIdc()!=null){
    s="Sucess";
       }
       return s;
    }

    public Club getClubByname(String clubname) {
        return this.clubRepo.findAllByNomclub(clubname);
    }

    public String AcceptClubDemande(CreationDemand demand) {
        Club club= new Club();
        club.setDescription(demand.getDescrpt());
        club.setEtat(true);

        if (rpedaRepo.findByIdE(demand.getIdpedag())==null){
            return "responsable pedagogique not found";
        }

        else {
        club.setPed(rpedaRepo.findByIdE(demand.getIdpedag()));
        log.info(demand.getNomClubD());
        club.setnomclub(demand.getNomClubD());
        log.info(club.getnomclub());


        Club test= clubRepo.save(club);
        if(test == null){
            return "Error while creating teh club";
        }else {
            log.info("Succesfully Created Club {} {}",test.getnomclub(),test.getDescription());
            Members members= new Members(test.getIdc(), demand.getIdEtudiant(), "pres");
            Members Mtest = memberRepo.save(members);
            if (Mtest == null) {
                return "error while saving the president";
            }else {
                log.info("Student {} is pres of Club {}",Mtest.getStudentid(), Mtest.getClubid() );
                return "Succesfully saved the club";
            }

        }
        }
    }

    public List<Club> getAllClub(int pagen, int size) {

        org.springframework.data.domain.Pageable pageable=  PageRequest.of(pagen,size);
        Page<Club> page=this.clubRepo.findAll(pageable);
        List<Club> clubs =Arrays.asList(page.getContent().toArray(new Club[0]));

        return clubs;
    }

    public String changeClubState(Long id,boolean state) {
        String response="Error";
        Club club = clubRepo.findByIdc(id);
        if (club==null)response="Club not found";
        else {
            club.setEtat(state);
            clubRepo.save(club);
            if (state==true){
                response = "activated Successfully";
            }else response="deactivated succefully";
        }

        return response;
    }

    public String addBudget(Long id,float budget) {
        String response="error";
        Club club=clubRepo.findByIdc(id);
        if (club==null){response="club not found";}
        else {
            club.setBudget(budget);
            clubRepo.save(club);
            response="saved the new budget";
        }
        return response;
    }

    public String changepedag(Long idpedag, Long idc) {
        Compte compte = accountRepo.findByIdE(idpedag);
        Club club=clubRepo.findByIdc(idc);
        if (compte==null){return "Compte not found";}else {
            if (club==null){
                return "error while finding the club";
            }else {
                if (club.getPed()==compte){
                    return "Mr/Ms "+ club.getPed().getfullname()+ " is already pedagogique director of this club";
                }else{ club.setPed(compte);
                    clubRepo.save(club);
                    log.info("saved "+ compte.getfullname()+ " as pedag for club "+ club.getnomclub());
                    return "done";}
            }
        }

    }

    public String addReunion(reunion r, Long idc) {
        String response="Error";
        Club club= clubRepo.findByIdc(idc);
        if (club==null) {response ="Club not found";}
        else {
            response="Successfully added the reunion";
        club.getReunions().add(r);
        log.info(club.getReunions().toString());
        clubRepo.save(club);}
        return response;
    }

    public String removereunion(Long id, Long idc) {
        String response="Error";
        Club club=clubRepo.findByIdc(idc);
        if (club==null){response ="Club not found";}else {
            club.getReunions().remove(reunionRepo.findByIdreunion(id));
           return "deleted Succefully";
        }
        return response;
    }
}
