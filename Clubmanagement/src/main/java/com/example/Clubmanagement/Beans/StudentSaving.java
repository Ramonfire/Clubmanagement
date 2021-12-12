package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class StudentSaving {
    private final PasswordEncoder passwordEncoder;

//Student saving
    @Bean
    CommandLineRunner commandLineRunnerCompte(EtudiantRepo repo){

        Etudiant e1 = new Etudiant("AA5449","Omar.Zaida","omar.zaida@uir.ac.ma",passwordEncoder.encode("123"),Long.valueOf(653822371),Long.valueOf(4),"info");
        Etudiant e2 = new Etudiant("AA5445","Jloul.bazkoul","jb@uir.ac.ma",passwordEncoder.encode("123"),Long.valueOf(653822371),Long.valueOf(4),"info");
        Etudiant e3 = new Etudiant("AA5446","anas.lfrnass","af@uir.ac.ma",passwordEncoder.encode("waitingforsignup"),Long.valueOf(653822371),Long.valueOf(4),"info");

        repo.saveAll(List.of(e1,e2,e3));

        return args -> {





        };
    }
}
