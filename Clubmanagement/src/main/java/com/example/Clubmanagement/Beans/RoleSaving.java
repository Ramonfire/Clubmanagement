package com.example.Clubmanagement.Beans;

import com.example.Clubmanagement.entities.compte.generlAc.Role;
import com.example.Clubmanagement.services.RclubsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleSaving {
    @Bean
    CommandLineRunner run(RclubsService rclubsService) {
        //basic account roles
        rclubsService.saveRole(new Role(null, "Role_Visitor"));
        rclubsService.saveRole(new Role(null, "Role_Student"));
        rclubsService.saveRole(new Role(null, "Role_Manager"));
        rclubsService.saveRole(new Role(null, "Role_Admin"));

        //member roles
        rclubsService.saveRole(new Role(null, "member_member"));
        rclubsService.saveRole(new Role(null, "member_Secretary"));
        rclubsService.saveRole(new Role(null, "member_tresorier"));
        rclubsService.saveRole(new Role(null, "member_Vpres"));
        rclubsService.saveRole(new Role(null, "member_pres"));


        return args -> {



        };
    }
}
