package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.RoleRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Role;
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
    private final EtudiantRepo etudiantRepo;
    private final RoleRepo roleRepo;



    public List<Etudiant> getallstudents(){
        return etudiantRepo.findAll();

    }
// a revoir!
    public Etudiant getStudentbyid(Long idmembre) {
         return this.etudiantRepo.getEtudiantByIdE(idmembre);

    }
    public Etudiant findAccount(String email){
        Etudiant compte= this.etudiantRepo.findByEmail(email);
        if (compte!=null || compte.getPass() == ""){
            //send an email!
            return compte;}
        else return new Etudiant("-1","-1","-1","-1",Long.valueOf(-1),Long.valueOf(-1),"non");

    }


    public void addStudentrole(){
        log.info("added Students roles");
        List<Etudiant> etudiants = etudiantRepo.findAll();
        Role role = roleRepo.findByName("Role_Student");
        for (Etudiant x: etudiants){
            x.getRoles().add(role);
        }
    }
}
