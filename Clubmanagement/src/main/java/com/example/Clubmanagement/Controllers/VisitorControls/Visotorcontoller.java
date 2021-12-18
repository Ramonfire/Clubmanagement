package com.example.Clubmanagement.Controllers.VisitorControls;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "Clubpage/Visitor")

public class Visotorcontoller {
    private final EventService eventService;
    private final ClubService clubService;
    private final EtudiantService etudiantService;
    private  final RclubsService rclubsService;




@Autowired
    public Visotorcontoller(EventService eventService, ClubService clubService, EtudiantService etudiantService, RclubsService rclubsService) {
        this.eventService = eventService;
        this.clubService = clubService;
        this.etudiantService = etudiantService;

    this.rclubsService = rclubsService;
}


    @GetMapping(path = "publicevent/{pagenum}/{size}")
    public List<evenement> getPublicevents(@PathVariable(required = false) int pagenum,@PathVariable(required = false) int size){
         return  eventService.getPevent(pagenum,size);
    }


    @GetMapping("events/{name}")
    public evenement getEventByname(@PathVariable("name") String name){
    return this.eventService.geteventByname(name);
    }

    @GetMapping(path ="allclubs/{page}/{size}")
    public List<Club> getallActiveClubs(@PathVariable(name = "page") int page,@PathVariable("size") int size){
    return clubService.getAllActiveClub(page,size);
    }
    @GetMapping(path = "Club/{id}")
    public Club getclub(@PathVariable("id") Long id){
        return clubService.getclub(id);
    }

    @GetMapping(path = "mot")
    public String getclub(){
        return rclubsService.returnMot();
    }
    @PutMapping(path = "signup/{email}")
    public String getAccount(@PathVariable("email") String email) {
    return this.etudiantService.Signup(email);
    }



}
