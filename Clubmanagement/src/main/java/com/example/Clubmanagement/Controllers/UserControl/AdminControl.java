package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "Clubpage/admin")
@Slf4j
public class AdminControl {

    private  final EventService eventService;
    private final DemandeService demandeService;
    private final EtudiantService etudiantService;
    private final ClubService clubService;
    private final MemberService memberService;
    private final RclubsService rclubs;

@Autowired
    public AdminControl(EventService eventService, DemandeService demandeService, EtudiantService etudiantService, ClubService clubService, MemberService memberService, RclubsService rclubs) {
        this.eventService = eventService;
    this.demandeService = demandeService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
    this.memberService = memberService;
    this.rclubs = rclubs;
}

    @GetMapping(path = "Allevents/{page}/{size}")
    public List<evenement> getallevents(@PathVariable(name = "page") int page,@PathVariable("size") int size){
    return eventService.getallevents(page, size);
    }
// to do pageable
    @GetMapping(path = "allDemandeclubs")
    public List<CreationDemand> getallDemands(){
    return demandeService.getAllDemands();
    }

    @GetMapping(value = "demandeclub/{etat}")
    public List<CreationDemand> getDemandebyState(@PathVariable("etat") int etat ){
    return demandeService.getdemandeBystate(etat);

    }

    /***counts****/
    @GetMapping(value = "demandeCount/{etat}")
    public int getCountDemandebyState(@PathVariable("etat") int etat ){
        return demandeService.getDemandesCountBystate(etat);

    }

    @GetMapping(value = "ClubCount")
    public int getCountClubsbyState(){
        return clubService.clubcount().intValue();

    }

    @GetMapping(path = "Countevents/{etat}")
    public  Long getallevents(@PathVariable("etat")int etat){
        return this.eventService.Countevents(etat);
    }


    /***end counts***/
    @GetMapping("events/{name}")
    public evenement getEventByname(@PathVariable("name") String name){
        return this.eventService.geteventByname(name);
    }

    @GetMapping(path ="allclubs/{page}/{size}")
    public List<Club> getallActiveClubs(@PathVariable(name = "page") int page,@PathVariable("size") int size){
        return clubService.getAllActiveClub(page,size);
    }

    @GetMapping(path = "Club/{id}")
    public Club getaclub(@PathVariable("id") Long id){
        return clubService.getclub(id);
    }





    @GetMapping(path = "members/{Clubid}/{page}/{size}")
    public ResponseEntity<List<Etudiant>> getAllStudents(@PathVariable("Clubid") Long Clubid,@PathVariable("page") int page,@PathVariable("size") int size){
        List<Members> members =this.memberService.getClubMembers(Clubid,page,size);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));
        }
        return ResponseEntity.ok().body(etudiants);
    }





    @GetMapping(path = "members/{id}/{role}/{page}/{size}")
    public List<Etudiant> getAllStudents(@PathVariable("role") String role,@PathVariable("id") Long id,@PathVariable("page")int page,@PathVariable("size") int size){
        List<Members> members =this.memberService.getClubMemberRole(id,role,page,size);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));

        }
        return etudiants;
    }

    @GetMapping(path = "All/{role}")
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
    @PostMapping(path = "saveMember/{clubname}/{role}/{idS}")
    public String insertMember(@PathVariable("clubname") String clubname, @PathVariable("role") String role,@PathVariable("idS")Long StudentID){
        Club club =clubService.getClubByname(clubname);
        if (club == null){
            return "club not found";
        }
        else {
        Members member = new Members(club.getIdc(),StudentID,role);
        return this.memberService.saveMember(member);}

    }

    @PostMapping(path = "updatemot")
    public String UpdateMot(@RequestBody mot mot){
        log.info("updated mot \n"+mot.mot);
        return rclubs.Changemot(mot.mot);
    }


}










class mot{
    public String mot;
}