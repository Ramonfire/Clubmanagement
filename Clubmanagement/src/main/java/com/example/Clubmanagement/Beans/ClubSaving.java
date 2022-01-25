package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
/*
@Configuration
public class ClubSaving {

    @Bean
    CommandLineRunner commandLineRunnerClub(ClubRepo repo) {

        Club C1 = new Club("Chillin side",Boolean.TRUE," Games.and.Movies ");
        Club C2 = new Club("Rotarac",Boolean.TRUE," Donor ");
        Club C3 = new Club("Bridge",Boolean.FALSE," Media ");

repo.saveAll(List.of(C1,C2,C3));
        return args -> {


        };
    }
}*/