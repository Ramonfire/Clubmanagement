package com.example.Clubmanagement.Controllers.VisitorControls;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.EtudiantService;
import com.example.Clubmanagement.services.EventService;
import com.example.Clubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping(path = "Clubpage/Visitor")

public class Visotorcontoller {
    private final EventService eventService;
    private final ClubService clubService;
    private final EtudiantService etudiantService;




@Autowired
    public Visotorcontoller(EventService eventService, ClubService clubService, EtudiantService etudiantService) {
        this.eventService = eventService;
        this.clubService = clubService;
        this.etudiantService = etudiantService;

}


    @GetMapping(path = "publicevent")
    public List<evenement> getPublicevents(){
    return  eventService.getPevent();
    }


    @GetMapping("events/{name}")
    public evenement getEventByname(@PathVariable("name") String name){
    return this.eventService.geteventByname(name);
    }

    @GetMapping(path ="allclubs/{page}/{size}")
    public List<Club> getallActiveClubs(@PathVariable("page") int page,@PathVariable("size") int size){
    return clubService.getAllActiveClub(page,size);

    }
    @GetMapping(path = "Club/{id}")
    public Club getclub(@PathVariable("id") Long id){
        return clubService.getclub(id);
    }

    @PutMapping(path = "signup/{email}")
    public String getAccount(@PathVariable("email") String email) {

        Compte etudiant = this.etudiantService.findAccount(email);
        String password="test";//Decrypt account pass and verify
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        if (etudiant!=null && encoder.matches(password,etudiant.getPass())){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            this.etudiantService.updatePassword(email,generatedString);
            //send the generate String through email

            return "Saved successfully";
        }
        else if (etudiant!=null && !encoder.matches(password,etudiant.getPass())){
            return "account already exists";
        }
            else return "Not an Uir student!";


    }



}
