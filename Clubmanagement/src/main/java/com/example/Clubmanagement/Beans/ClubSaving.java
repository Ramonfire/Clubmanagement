package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.RpedaRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ClubSaving {
    private final RpedaRepo repo1;

    @Bean
    CommandLineRunner commandLineRunnerClub(ClubRepo repo) {

        Club C1 = new Club("Chillin side",Boolean.TRUE," Games.and.Movies ");
        Club C2 = new Club("Rotarac",Boolean.TRUE," Donor ");
        Club C3 = new Club("Bridge",Boolean.FALSE," Media ");
        C1.setPed(repo1.getById(Long.valueOf(1)));
        C2.setPed(repo1.getById(Long.valueOf(2)));
        C3.setPed(repo1.getById(Long.valueOf(1)));

repo.saveAll(List.of(C1,C2,C3));
        return args -> {


        };
    }
}