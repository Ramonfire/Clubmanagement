package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.DemandeRepo;
import com.example.Clubmanagement.Repositories.RclubsRepo;
import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
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
public class DemandeService {

    private final DemandeRepo demandeRepo;
    private final ClubRepo clubRepo;

    public List<CreationDemand> getAllDemands(){
        return demandeRepo.findAll();
}


public  List<CreationDemand> getdemandeBystate(int etat, int pagenum,int size){
    org.springframework.data.domain.Pageable pageable=  PageRequest.of(pagenum,size);
    Page<CreationDemand> demands = demandeRepo.findAllByEtatD(etat,pageable);
    List<CreationDemand> demands1 = Arrays.asList(demands.getContent().toArray(new CreationDemand[0]));

        return demands1;}
    public List<CreationDemand> getEtudiantDemande(Long idE){return demandeRepo.getAllByIdEtudiant(idE);}

    public int getDemandesCountBystate(int etat){
    return demandeRepo.countAllByEtatD(etat);
    }

    //saveguard de demande
    public String saveDemande(CreationDemand demand){
        CreationDemand demand1 = new CreationDemand();


        log.info("saving Demande : {}",demand.toString() );
        if (clubRepo.findAllByNomclub(demand.getNomClubD())==null) {demand1 = demandeRepo.save(demand);}else {return "Club already exist \n  choose an other name or join the existin club";}

        if (demand1 == null){
            return "try again something went wrong";
        }else return "demande saved for club creation : " +demand.getNomClubD();
    }


    public Boolean updateDemandeState(CreationDemand demand, int i) {
        demand.setEtatD(i);
        CreationDemand testing = demandeRepo.save(demand);
        if (testing == null) {
            return true;
        }else return false;
    }
}
