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
public class AfactureSaving {
    @Bean
    CommandLineRunner savingFacture(FactureRepo factureRepo,EventRepo eventRepo){
      factureRepo.save(new facture(null,Long.valueOf(600),"testing",eventRepo.findByNomevent("testing")));
        factureRepo.save(new facture(null,Long.valueOf(600),"testing1",eventRepo.findByNomevent("testing1")));
        factureRepo.save(new facture(null,Long.valueOf(600),"testing2",eventRepo.findByNomevent("testing2")));
        factureRepo.save(new facture(null,Long.valueOf(600),"testing3",eventRepo.findByNomevent("testing3")));
        factureRepo.save(new facture(null,Long.valueOf(600),"testing4",eventRepo.findByNomevent("testing4")));

        return args -> {};
    }
}
