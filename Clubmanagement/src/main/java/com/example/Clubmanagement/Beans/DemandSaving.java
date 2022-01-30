package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.DemandeRepo;
import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DemandSaving {
    @Bean
    CommandLineRunner commandLineRunnerDemande(DemandeRepo demandeRepo) {

        CreationDemand d1 = new CreationDemand(null,Long.valueOf(5),"Club","testDemande1","testing",0,Long.valueOf(1));
        CreationDemand d2 = new CreationDemand(null,Long.valueOf(5),"Club","testDemande1","testing",0,Long.valueOf(2));
        CreationDemand d3 = new CreationDemand(null,Long.valueOf(5),"Club","testDemande1","testing",0,Long.valueOf(1));
        demandeRepo.saveAll(List.of(d1,d2,d3));
        return args -> {


        };
    }
}
