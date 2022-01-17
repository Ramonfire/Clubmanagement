package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClubService {

    private final ClubRepo clubRepo;


    public List<Club> getAllActiveClub(int pagenum,int size){
        org.springframework.data.domain.Pageable pageable=  PageRequest.of(pagenum,size);
        Page<Club> page=this.clubRepo.findAll(pageable);

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
}
