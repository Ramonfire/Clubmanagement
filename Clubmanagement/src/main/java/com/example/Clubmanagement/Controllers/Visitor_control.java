package com.example.Clubmanagement.Controllers;

import com.example.Clubmanagement.Services.Service_general;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Visitor_control {
    public  final Service_general srv;

    @Autowired
    public  Visitor_control(Service_general srv){

        this.srv=srv;
    }


    @GetMapping
    public List<evenement> Getevent(){
            return  srv.getallPevents();
    }
    @GetMapping
    public List<Club> getClubs(){

        return  srv.getallclubs();
    }


}
