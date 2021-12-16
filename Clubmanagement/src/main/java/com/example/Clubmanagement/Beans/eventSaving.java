package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EventRepo;
import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class eventSaving {
    @Bean
    CommandLineRunner savingevents(EventRepo eventRepo, ClubRepo clubRepo){
        eventRepo.save( new evenement(null,"test","testing", 0,0,clubRepo.findByIdc(Long.valueOf(1)),null));
        eventRepo.save( new evenement(null,"test1","testing1", 0,1,clubRepo.findByIdc(Long.valueOf(1)),null));
        eventRepo.save( new evenement(null,"test2","testing2", 0,1,clubRepo.findByIdc(Long.valueOf(2)),null));
        eventRepo.save( new evenement(null,"test3","testing3", 0,1,clubRepo.findByIdc(Long.valueOf(3)),null));
        eventRepo.save( new evenement(null,"test4","testing4", 0,-1,clubRepo.findByIdc(Long.valueOf(1)),null));
        return args -> {};
    }
}
