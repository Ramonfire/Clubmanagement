package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "Clubpage/admin")
public class AdminControl {

    private  EventService eventService;
    private DemandeService demandeService;
    private EtudiantService etudiantService;
    private ClubService clubService;
    private MemberService memberService;

@Autowired
    public AdminControl(EventService eventService, DemandeService demandeService, EtudiantService etudiantService, ClubService clubService, MemberService memberService) {
        this.eventService = eventService;
    this.demandeService = demandeService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
    this.memberService = memberService;

}

    @GetMapping(path = "events")
    public List<evenement> getallevents(){
    return eventService.getallevents();
    }

    @GetMapping(path = "all_clubs")
    public List<CreationDemand> getallDemands(){
    return demandeService.getAllDemands();
    }

    @GetMapping(value = "demandeclub/{etat}")
    public List<CreationDemand> getDemandebyState(@PathVariable("etat") boolean etat ){
    return demandeService.getdemandeBystate(etat);

    }
    @GetMapping(path = "public_event")
    public List<evenement> getPublicevents(){
        return  eventService.getPevent();

    }
    @GetMapping(path ="all_clubs/{etat}")
    public List<Club> getallClubs(@PathVariable("etat") boolean etat ){
        return clubService.getAllClubs(etat);
    }

    @GetMapping(path = "Club/{id}")
    public Club getclub(@PathVariable("id") Long id){

    return clubService.getclubs(id);
    }
    @GetMapping(path = "Etudiant")
    public List<Etudiant> getAllStudents(){
return etudiantService.getallstudents();
    }

    @GetMapping(path = "members/{Clubid}")
    public List<Etudiant> getAllStudents(@PathVariable("Clubid") Long Clubid){
        List<Members> members =this.memberService.getClubMembers(Clubid);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));

        }
        return etudiants;
    }
    //Members By Role
    @GetMapping(path = "Role/{Role}")
    public List<Members> getMemberRole(@PathVariable("Role") String Role){return this.memberService.getClubRoles(Role);}

    @GetMapping(path = "Countevents/{etat}")
    public  Long getallevents(@PathVariable("etat")int etat){
    return this.eventService.Countevents(etat);
    }



    @PostMapping(path = "saveClub")
    public String insertClub(@RequestBody Club club){
    return this.clubService.saveclub(club);

    }
    @PostMapping(path = "saveMember")
    public String insertMember(@RequestBody Members member){
        return this.memberService.saveMember(member);

    }


}
