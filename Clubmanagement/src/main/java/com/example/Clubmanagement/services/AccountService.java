package com.example.Clubmanagement.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.Clubmanagement.Repositories.AccountRepo;
import com.example.Clubmanagement.Repositories.MemberRepo;
import com.example.Clubmanagement.Repositories.RoleRepo;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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


    public Compte getAccountbymail(String email){
        return this.accountRepo.findByEmail(email);
    }


    // get user through header
    public   Compte getaccoutThroughheader() throws IOException {
        Compte compte =accountRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return compte;
    }


    public List<Compte> getallaccounts() {
      return   accountRepo.findAll();
    }
}

