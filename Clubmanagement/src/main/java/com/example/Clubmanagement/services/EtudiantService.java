package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EtudiantService {
    private EtudiantRepo etudiantRepo;



    public List<Etudiant> getallstudents(){
        return etudiantRepo.findAll();

    }
// a revoir!
    public Etudiant getStudentbyid(Long idmembre) {
         return this.etudiantRepo.getEtudiantByIdE(idmembre);

    }
    public Etudiant findAccount(String email){
        Etudiant compte= this.etudiantRepo.findByEmail(email);
        if (compte!=null)
            return compte;
        else return new Etudiant("-1","-1","-1","-1",Long.valueOf(-1),Long.valueOf(-1),"non");

    }
}
