package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.RpedaRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.reunion;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ClubSaving {
    private final RpedaRepo repo1;

    @Bean
    CommandLineRunner commandLineRunnerClub(ClubRepo repo) {

        Club C1 = new Club("Chillin side",Boolean.TRUE," Un club d’animation qui aide à l’organisation de différents événements et activités de divertissement au sein de la communauté UIR, notamment des projections de films hebdomadaires, l’organisation de tournois de jeux vidéo, des chasses au trésor etc.. ");
        Club C2 = new Club("Rotarac",Boolean.TRUE," Le Club, branche reconnue du Rotaract Morocco, s’engage dans des actions sociales au profit de certains quartiers marginalisés dans la région de Rabat et les zones enclavés du Royaume. ");
        Club C3 = new Club("Bridge",Boolean.FALSE," Le journal universitaire des étudiants par excellence. Une passerelle permettant d’établir un lien entre les étudiants en les dotant d’une voix unifiée fondée sur la liberté d’expression. ");
        C1.setPed(repo1.getById(Long.valueOf(1)));
        C2.setPed(repo1.getById(Long.valueOf(2)));
        C3.setPed(repo1.getById(Long.valueOf(1)));
         List<reunion> arrays= new ArrayList<reunion>();
      arrays.add(new reunion(LocalDateTime.now(),Long.valueOf(60),"test","home"));
        C1.setReunions(arrays);

repo.saveAll(List.of(C1,C2,C3));
        return args -> {


        };
    }
}