package com.example.Clubmanagement.Controllers.VisitorControls;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Role;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.EtudiantService;
import com.example.Clubmanagement.services.EventService;
import com.example.Clubmanagement.services.MemberService;
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
    private final EtudiantService etudiantService;
    private final MemberService memberService;



@Autowired
    public Visotorcontoller(EventService eventService, ClubService clubService, EtudiantService etudiantService, MemberService memberService) {
        this.eventService = eventService;
        this.clubService = clubService;
        this.etudiantService = etudiantService;
        this.memberService = memberService;
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
    public Etudiant getAccount(@PathVariable("email") String email){
    //make an email sending api!
      Etudiant etudiant=  this.etudiantService.findAccount(email);
        Members members = this.memberService.getmemberbystudentid(etudiant.getId());
        for (Role x : members.getRoles())
        etudiant.getRoles().add(x);
    return etudiant;
    }



}
