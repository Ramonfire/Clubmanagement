package com.example.Clubmanagement.Controllers.VisitorControls;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping(path = "Clubpage/Visitor")
@Slf4j

public class Visotorcontoller {
    private final EventService eventService;
    private final ClubService clubService;
    private final EtudiantService etudiantService;
    private  final RclubsService rclubsService;
    private final MemberService memberService;




@Autowired
    public Visotorcontoller(EventService eventService, ClubService clubService, EtudiantService etudiantService, RclubsService rclubsService, MemberService memberService) {
        this.eventService = eventService;
        this.clubService = clubService;
        this.etudiantService = etudiantService;

    this.rclubsService = rclubsService;
    this.memberService = memberService;
}


    @GetMapping(path = "publicevent/{pagenum}/{size}")
    public List<evenement> getPublicevents(@PathVariable(required = false) int pagenum,@PathVariable(required = false) int size){
         return  eventService.getPevent(pagenum,size);
    }


    @GetMapping("events/{name}")
    public evenement getEventByname(@PathVariable("name") String name){
    return this.eventService.geteventByname(name);
    }

    @GetMapping("event/{id}")
    public Optional<evenement> getEventByid(@PathVariable("id") Long id){
    return  this.eventService.getEventById(id);
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
    public ResponseEntity<String> getclub(){
        return  ResponseEntity.ok().body(rclubsService.returnMot());
    }
    @GetMapping(path = "signup/{email}")
    public String getAccount(@PathVariable("email") String email) {
    return this.etudiantService.Signup(email);
    }





    @GetMapping("getResp/{id}")
    public String getSecretaire(@PathVariable("id") Long id){
    Optional<evenement> evenement= eventService.getEventById(id);
    Club club = evenement.get().getC();
   List<Members> members = memberService.getClubMemberRole(club.getIdc(),"secr",0,1);
   if (members.size()==0){return "Rachid.hadre@uir.ac.ma";}
   else {
   Etudiant etudiant = etudiantService.getStudentbyid(members.get(0).getStudentid());
    return etudiant.getEmail();}
    }

}
