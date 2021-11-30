package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CompteSaving {

//Student saving
    @Bean
    CommandLineRunner commandLineRunnerCompte(EtudiantRepo repo){

        Etudiant e1 = new Etudiant("AA5449","Omar.Zaida","omar.zaida@uir.ac.ma","Test",Long.valueOf(653822371),Long.valueOf(4),"info");
        Etudiant e2 = new Etudiant("AA5445","Jloul.bazkoul","JB@uir.ac.ma","Test",Long.valueOf(653822371),Long.valueOf(4),"info");
        Etudiant e3 = new Etudiant("AA5446","anas.lfrnass","AF@uir.ac.ma","Test",Long.valueOf(653822371),Long.valueOf(4),"info");

        repo.saveAll(List.of(e1,e2,e3));

        return args -> {





        };
    }
}
