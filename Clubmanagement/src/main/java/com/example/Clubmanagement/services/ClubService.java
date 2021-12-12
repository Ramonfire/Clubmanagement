package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClubService {

    private final ClubRepo clubRepo;

    public List<Club> getAllActiveClub(){
        return this.clubRepo.findAll();

    }

    public  List<Club> getAllClubs(boolean etat){
        return  this.clubRepo.findByEtat(etat);

    }


    public Club getclub(Long id) {
        return  this.clubRepo.findByIdc(id);
    }
//get a students Club list
    public  List<Club> GetMembersClub(Etudiant s) {
        return this.clubRepo.findAllByStudents(s);

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
