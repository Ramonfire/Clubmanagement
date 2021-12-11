package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.RclubsRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RclubsSaving {

    @Bean
    CommandLineRunner commandLineRunnerRclubs(RclubsRepo rclubsrepo){

        Rclubs r1 = new  Rclubs("AA5449","Rachid Hadre","rachid.hard@uir.ac.ma","admin123",Long.valueOf(6666666),"this is a test");
        Rclubs r2 = new  Rclubs("AA5441","admin","admin","admin1234",Long.valueOf(6666666),"this is a test");


        rclubsrepo.saveAll(List.of(r1,r2));

        return args -> {



        };
    }
}
