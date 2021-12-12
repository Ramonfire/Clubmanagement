package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.RclubsRepo;
import com.example.Clubmanagement.Repositories.RpedaRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import com.example.Clubmanagement.entities.compte.generlAc.Rpedag;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration

@RequiredArgsConstructor
public class RpedagSaving {
private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunnerRpedag(RpedaRepo repo){

        Rpedag r1 = new Rpedag("AA5459","test","bg@uir.ac.ma",passwordEncoder.encode("amdmin123"),Long.valueOf(6666666),"this is a test");
        Rpedag r2 = new Rpedag("AA5437","prof","prof@uir.ac.ma",passwordEncoder.encode("amdmin123"),Long.valueOf(6666666),"this is a test");


        repo.saveAll(List.of(r1,r2));

        return args -> {



        };
    }
}
