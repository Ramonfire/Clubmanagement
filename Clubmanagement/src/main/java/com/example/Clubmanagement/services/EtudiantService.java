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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


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


    public String Signup(String email){
        Compte etudiant = this.etudiantRepo.findByEmail(email);
        String password="test";//Decrypt account pass and verify
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        if (etudiant!=null && encoder.matches(password,etudiant.getPass())){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            this.updatePassword(email,generatedString);
            //send the generate String through email

            return "Saved successfully";
        }
        else if (etudiant!=null && !encoder.matches(password,etudiant.getPass())){
            return "account already exists";
        }
        else return "Not an Uir student!";
    }
}
