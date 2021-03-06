package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.ClubRepo;
import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.MemberRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MemberSaving {
    ClubRepo Crp;
    EtudiantRepo Erp;

    @Bean
    CommandLineRunner commandLineRunnerClubMember(MemberRepo repo) {



        Members m1 = new Members(null,Long.valueOf(1),Long.valueOf(9),"member");
        Members m2 = new Members(null,Long.valueOf(1),Long.valueOf(7),"pres");
        Members m3 = new Members(null,Long.valueOf(2),Long.valueOf(8),"Vpres");
        Members m4 = new Members(null,Long.valueOf(1),Long.valueOf(8),"secr");


        repo.saveAll(List.of(m1,m2,m3,m4));
        return args -> {


        };
    }
}
