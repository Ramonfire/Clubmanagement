package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.*;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import com.example.Clubmanagement.entities.compte.generlAc.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class RclubsService  {

private final RoleRepo roleRepo;
private final EtudiantRepo etudiantRepo;
private final MemberRepo memberRepo;
private  final RclubsRepo rclubsRepo;
private final AccountRepo accountRepo;





//sauvegrder un role (admin donne acces)
    public Role saveRole(Role role){
        return this.roleRepo.save(role);
    }




// a revoir

    public void addRoleToMember(String email,String Role,Long idClub){
        log.info("Added role{} to Student{}",Role,email);

        Role role=roleRepo.findByName(Role);
        Etudiant etudiant = this.etudiantRepo.findByEmail(email);
        Members members=new Members();
        if (etudiant!=null) {members=memberRepo.findByStudentidAndClubid(etudiant.getIdE(),idClub);
            if (members == null) {
                System.out.println("not a member");
                members=memberRepo.save(new Members(null,etudiant.getIdE(), idClub,Role));
            }else{
                //verifions si les memberes et deja president ou si il exist deja un president(si oui on va le render comme un membre normal)
            }
             members.setRole(Role);
        }
        else System.out.println("erreur etudiant no found");
    }

    public void addRoleToAdmin(String email,String Role){
        log.info("Added role{} to Admin{}",Role,email);
        Role role=roleRepo.findByName(Role);
        Rclubs rclubs = this.rclubsRepo.findByEmail(email);

            rclubs.getRoles().add(role);
    }

    public  void addRoletoAccount(String email,String Role){
        log.info("Added role{} to account{}",Role,email);
        Role role=roleRepo.findByName(Role);
        Compte cmp= this.accountRepo.findByEmail(email);
        cmp.getRoles().add(role);
    }


public String returnMot(){
       Rclubs rclubs = this.rclubsRepo.findByEmail("rachid.hard@uir.ac.ma");
    log.info("got mot  {} of {} ",rclubs.getMot(),rclubs.getEmail());
       return rclubs.getMot();
}
}
