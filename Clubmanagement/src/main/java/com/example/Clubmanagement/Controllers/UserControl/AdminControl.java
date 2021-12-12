package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "Clubpage/admin")
public class AdminControl {

    private  final EventService eventService;
    private final DemandeService demandeService;
    private final EtudiantService etudiantService;
    private final ClubService clubService;
    private final MemberService memberService;

@Autowired
    public AdminControl(EventService eventService, DemandeService demandeService, EtudiantService etudiantService, ClubService clubService, MemberService memberService) {
        this.eventService = eventService;
    this.demandeService = demandeService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
    this.memberService = memberService;

}

    @GetMapping(path = "Allevents")
    public List<evenement> getallevents(){
    return eventService.getallevents();
    }

    @GetMapping(path = "allDemandeclubs")
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
    @GetMapping(path ="clubs/{etat}")
    public List<Club> getallClubs(@PathVariable("etat") boolean etat ){
        return clubService.getAllClubs(etat);
    }

    @GetMapping(path = "Club/{id}")
    public Club getclub(@PathVariable("id") Long id){

    return clubService.getclub(id);
    }
    @GetMapping(path = "Etudiant")
    public ResponseEntity<List<Etudiant>>getAllStudents(){return ResponseEntity.ok().body(etudiantService.getallstudents());}

    @GetMapping(path = "Etudiant/{email}")
    public ResponseEntity<Etudiant>getStudentbyemail(@PathVariable("email") String email){return ResponseEntity.ok().body(etudiantService.findAccount(email));}

    @GetMapping(path = "members/{Clubid}")
    public ResponseEntity<List<Etudiant>> getAllStudents(@PathVariable("Clubid") Long Clubid){
        List<Members> members =this.memberService.getClubMembers(Clubid);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));

        }
        return ResponseEntity.ok().body(etudiants);
    }


    @GetMapping(path = "Countevents/{etat}")
    public  Long getallevents(@PathVariable("etat")int etat){
    return this.eventService.Countevents(etat);
    }


    @GetMapping(path = "members/{id}/{role}")
    public List<Etudiant> getAllStudents(@PathVariable("role") String role,@PathVariable("id") Long id){
        List<Members> members =this.memberService.getClubMember(id,role);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));

        }
        return etudiants;
    }

    @GetMapping(path = "All/{Role}")
    public ResponseEntity<List<Etudiant>> getAllRole(@PathVariable("role") String role){
        List<Members> members =this.memberService.getAllMembersByRole(role);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));

        }
        return ResponseEntity.ok().body(etudiants);
    }

    @GetMapping(path = "events")
    public List<evenement> geteventsbyClub(@RequestParam Club club){return eventService.getClubevent(club);}
//*************************************************************************************post mapping*************************************************************************//

    @PostMapping(path = "saveClub")
    public String insertClub(@RequestBody Club club){
    return this.clubService.saveclub(club);

    }
    @PostMapping(path = "saveMember")
    public String insertMember(@RequestBody Members member){
        return this.memberService.saveMember(member);

    }


}
