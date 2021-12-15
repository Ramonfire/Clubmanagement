package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.MemberRepo;
import com.example.Clubmanagement.Repositories.RoleRepo;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EtudiantService  {
    private final EtudiantRepo etudiantRepo;
    private final RoleRepo roleRepo;
    private final MemberRepo memberRepo;









    public List<Etudiant> getallstudents(){
        return etudiantRepo.findAll();

    }
// a revoir!
    public Etudiant getStudentbyid(Long idmembre) {
         return this.etudiantRepo.getEtudiantByIdE(idmembre);

    }

    //to return a bool. true for account found and email sent. false for account not found.
    public Etudiant findAccount(String email){
        return  this.etudiantRepo.findByEmail(email);
    }


    public void addStudentrole(){
        log.info("added Students roles");
        List<Etudiant> etudiants = etudiantRepo.findAll();
        Role role = roleRepo.findByName("Role_Student");
        for (Etudiant x: etudiants){
            x.getRoles().add(role);
        }
    }


    public void updatePassword(String email,String generatedString) {
        Etudiant etudiant = this.findAccount(email);
        etudiant.setPass(generatedString);
        this.etudiantRepo.save(etudiant);
    }
}
