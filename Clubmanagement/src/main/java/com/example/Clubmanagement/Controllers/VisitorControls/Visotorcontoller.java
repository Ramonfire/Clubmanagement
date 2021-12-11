package com.example.Clubmanagement.Controllers.VisitorControls;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.services.AccountService;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "Clubpage/Visitor")
public class Visotorcontoller {
    private final EventService eventService;
    private final ClubService clubService;
    private final AccountService accountService;



@Autowired
    public Visotorcontoller(EventService eventService, ClubService clubService, AccountService accountService) {
        this.eventService = eventService;
        this.clubService = clubService;

    this.accountService = accountService;
}


    @GetMapping(path = "publicevent")
    public List<evenement> getPublicevents(){
    return  eventService.getPevent();

    }
    @GetMapping(path ="allclubs")
    public List<Club> getallActiveClubs(){
    return clubService.getAllActiveClub();

    }
    @GetMapping(path = "Club/{id}")
    public Club getclub(@PathVariable("id") Long id){

        return clubService.getclub(id);
    }

    @GetMapping(path = "signup/{email}")
    public Compte getAccount(@PathVariable("email") String email){
    return this.accountService.findAccount(email);
    }



}
