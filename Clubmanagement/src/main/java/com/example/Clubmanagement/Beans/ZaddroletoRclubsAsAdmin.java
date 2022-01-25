package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.services.RclubsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZaddroletoRclubsAsAdmin {
    @Bean
    CommandLineRunner addingroletoadmin(RclubsService rclubsService){
        rclubsService.addRoleToAdmin("rachid.hard@uir.ac.ma","Role_Admin");



        return  args -> {};
    }
}
