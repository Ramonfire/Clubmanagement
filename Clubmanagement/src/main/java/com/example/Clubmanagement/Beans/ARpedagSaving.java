package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.Repositories.AccountRepo;
import com.example.Clubmanagement.Repositories.RclubsRepo;
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
public class ARpedagSaving {
    private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunnerRPedag(AccountRepo accountRepo){

        Rpedag r1 = new  Rpedag("AA5449","test pedag1","test",passwordEncoder.encode("123"),Long.valueOf(6666666),"this is a test");
        Rpedag r2 = new  Rpedag("AA5441","test pedag2","test",passwordEncoder.encode("123"),Long.valueOf(6666666),"this is a test");


        accountRepo.saveAll(List.of(r1,r2));

        return args -> {



        };
    }
}
