package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
    private final AccountService accountService;

@Autowired
    public AdminControl(EventService eventService, DemandeService demandeService, EtudiantService etudiantService, ClubService clubService, MemberService memberService, RclubsService rclubs, AccountService accountService) {
        this.eventService = eventService;
    this.demandeService = demandeService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
    this.memberService = memberService;
    this.rclubs = rclubs;
    this.accountService = accountService;
}

    @GetMapping(path = "Allevents/{page}/{size}")
    public List<evenement> getallevents(@PathVariable(name = "page") int page,@PathVariable("size") int size){
    return eventService.getallevents(page, size);
    }


    @GetMapping(path="Waitingevents/{page}/{size}")
    public List<evenement> getWatingevents(@PathVariable("page") int page,@PathVariable("size") int size){
    return eventService.geteventbyState(0,page,size);
    }
/***accepter/refuser events**/
    @GetMapping("Refuserevent/{id}")
    public String RefuseEvent(@PathVariable("id") Long id){
    return eventService.ChangeEventState(id,-1);
    }
    @GetMapping("Acecpterevent/{id}")
    public String AccepterEvent(@PathVariable("id") Long id){
        return eventService.ChangeEventState(id,1);
    }



// to do pageable
    @GetMapping(path = "allDemandeclubs")
    public List<CreationDemand> getallDemands(){
    return demandeService.getAllDemands();
    }

    @GetMapping(value = "demandeclub/{etat}/{page}/{size}")
    public List<CreationDemand> getDemandebyState(@PathVariable("etat") int etat ,@PathVariable("page") int page,@PathVariable("size") int size){
    return demandeService.getdemandeBystate(etat,page,size);

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
    public List<Club> getallClubs(@PathVariable(name = "page") int page,@PathVariable("size") int size){
        return clubService.getAllClub(page,size);
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

    @GetMapping(path = "ChangeClubstate/{state}/{id}")
    public String ChangeClubState(@PathVariable("state") boolean state,@PathVariable("id") Long id){
        return this.clubService.changeClubState(id,state);
    }

    @GetMapping(path = "newBudget/{id}/{budget}")
    public String AddBudget(@PathVariable("budget") float budget,@PathVariable("id") Long id){
        return clubService.addBudget(id,budget);
    }

    @GetMapping(path = "changeterminer/{terminer}")
    public String changeterminer(@PathVariable Long terminer){
        return eventService.ChangeTerminer(terminer);
    }



    @PostMapping(path = "updatemot")
    public String UpdateMot(@RequestBody mot mot){
        log.info("updated mot \n"+mot.mot);
        return rclubs.Changemot(mot.mot);
    }

    @PostMapping("accepterDemande")
    public String AccepterDemande(@RequestBody CreationDemand demand){
        log.info("Demande to create club {} accepted ",demand.getNomClubD());
        String response;
        demandeService.updateDemandeState(demand, 1);
       return clubService.AcceptClubDemande(demand);
    }

    @PostMapping("refuserDemande")
    public String RefuserDemande(@RequestBody CreationDemand demand){
        log.info("Demande to create club {} revoqued ",demand.getNomClubD());
        boolean x= demandeService.updateDemandeState(demand, -1);
        if (x==false){
            return "done";
        }else return " Error !please try again";

    }

    @PostMapping(path = "saveComite/{id}")
    public String insertMember(@RequestBody newMember newMember,@PathVariable("id") Long id){
        Compte compte=accountService.getAccountbymail(newMember.getEmail());
        if (compte==null){return"Account not found";}
        Members member = new Members(id,compte.getIdE(),newMember.getRole());
        return this.memberService.saveComite(member);
    }


    /****put mapping***/




}


@Data
@Getter
@Setter
@AllArgsConstructor
class newMember{
   private String email;
    private String role;
}










class mot{
    public String mot;
}