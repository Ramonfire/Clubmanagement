package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.entities.club.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepo clubRepo;

    @Autowired
    public ClubService(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    public List<Club> getAllActiveClub(){
        return this.clubRepo.findAll();

    }

    public  List<Club> getAllClubs(boolean etat){
        return  this.clubRepo.findByEtat(etat);

    }


    public Club getclubs(Long id) {
        return  this.clubRepo.findByIdc(id);
    }
}
