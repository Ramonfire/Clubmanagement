package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.services.RclubsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Zaddroletouser {
    @Bean
    CommandLineRunner addingrole(RclubsService rclubsService){
        rclubsService.addRoleToMember("omar.zaida@uir.ac.ma","member_pres",Long.valueOf(1));
        rclubsService.addRoleToAdmin("rachid.hard@uir.ac.ma","Role_Admin");



        return  args -> {};
    }
}
