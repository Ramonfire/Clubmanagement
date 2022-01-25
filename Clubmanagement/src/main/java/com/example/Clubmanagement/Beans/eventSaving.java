package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EventRepo;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.club.facture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class eventSaving {
    //create facture then insert into event
    @Bean
    CommandLineRunner savingevents(EventRepo eventRepo, ClubRepo clubRepo){
        eventRepo.save( new evenement(null,"test","testing", 0,0,false,clubRepo.findByIdc(Long.valueOf(1)),new facture(Long.valueOf(600),"testing")));
        eventRepo.save( new evenement(null,"test1","testing1", 0,1,true,clubRepo.findByIdc(Long.valueOf(1)),new facture(Long.valueOf(0),"testing1")));
        eventRepo.save( new evenement(null,"test2","testing2", 0,1,false,clubRepo.findByIdc(Long.valueOf(2)),new facture(Long.valueOf(5),"testing2")));
        eventRepo.save( new evenement(null,"test3","testing3", 0,1,false,clubRepo.findByIdc(Long.valueOf(3)),new facture(Long.valueOf(1000),"testing3")));
        eventRepo.save( new evenement(null,"test4","testing4", 0,-1,false,clubRepo.findByIdc(Long.valueOf(1)),new facture(Long.valueOf(500),"testing4")));
        return args -> {};
    }
}
