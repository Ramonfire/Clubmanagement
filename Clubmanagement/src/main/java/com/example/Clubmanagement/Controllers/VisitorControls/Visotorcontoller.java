package com.example.Clubmanagement.Controllers.VisitorControls;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "Clubpage/welcome")
public class Visotorcontoller {
    private EventService eventService;
    private ClubService clubService;

@Autowired
    public Visotorcontoller(EventService eventService, ClubService clubService) {
        this.eventService = eventService;
        this.clubService = clubService;
    }


    @GetMapping(path = "publicevent")
    public List<evenement> getPublicevents(){
    return  eventService.getPevent();

    }
    @GetMapping(path ="allclubs")
    public List<Club> getallClubs(){
    return clubService.getAllClub();

    }

}
