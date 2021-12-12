package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.AccountRepo;
import com.example.Clubmanagement.Repositories.MemberRepo;
import com.example.Clubmanagement.Repositories.RoleRepo;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService implements UserDetailsService {
    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;
    private final MemberRepo memberRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Compte cmp = accountRepo.findByEmail(email);
        if(cmp==null){
            log.error("compte not found");
            throw  new UsernameNotFoundException("compte not found");
        }else{log.info("compte  found: " +email);

        }
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            cmp.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));});
            return new org.springframework.security.core.userdetails.User(cmp.getEmail(),cmp.getPass(),authorities);
    }


    public Etudiant saveStudent(Etudiant etudiant){
        etudiant.setPass(passwordEncoder.encode(etudiant.getPass()));
    return this.accountRepo.save(etudiant);
    }




}
