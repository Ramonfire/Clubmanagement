package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    private EtudiantRepo etudiantRepo;

    @Autowired

    public EtudiantService(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    public List<Etudiant> getallstudents(){
        return etudiantRepo.findAll();

    }
// a revoir!
    public Etudiant getStudentbyid(Long idmembre) {
         return this.etudiantRepo.getEtudiantByIdE(idmembre);

    }
}
