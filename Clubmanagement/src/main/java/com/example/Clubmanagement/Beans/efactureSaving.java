package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EventRepo;
import com.example.Clubmanagement.Repositories.FactureRepo;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.club.facture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class efactureSaving {
    @Bean
    CommandLineRunner savingFacture(FactureRepo factureRepo){
      factureRepo.save(new facture(Long.valueOf(600),"testing"));
        factureRepo.save(new facture(Long.valueOf(500),"testing1"));
        factureRepo.save(new facture(Long.valueOf(0),"testing2"));
        factureRepo.save(new facture(Long.valueOf(200),"testing3"));
        factureRepo.save(new facture(Long.valueOf(200),"testing4"));

        return args -> {};
    }
}
