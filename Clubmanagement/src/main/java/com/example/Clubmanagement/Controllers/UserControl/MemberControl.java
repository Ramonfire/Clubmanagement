package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.club.facture;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.*;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "Clubpage/member")
@Slf4j
public class MemberControl {
     private final MemberService memberService;
     private final EtudiantService etudiantService;
     private final ClubService clubService;
     private final EventService eventService;
     private final AccountService accountService;




@Autowired
    public MemberControl(MemberService memberService, EtudiantService etudiantService, ClubService clubService, EventService eventService, AccountService accountService) {
        this.memberService = memberService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
    this.eventService = eventService;
    this.accountService = accountService;
}



    @GetMapping(path = "members/{Clubid}/{page}/{size}")
    public ResponseEntity<List<Etudiant>> getAllStudents(@PathVariable("Clubid") Long Clubid, @PathVariable("page") int page, @PathVariable("size") int size){
        List<Members> members =this.memberService.getClubMembers(Clubid,page,size);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));
        }
        return ResponseEntity.ok().body(etudiants);
    }


    @GetMapping(path = "events/{type}/{pagenum}/{size}")
    public List<evenement> geteventsbytype(@PathVariable int type,@PathVariable int pagenum,@PathVariable int size){
    return this.eventService.geteventbytype(type,pagenum,size);
    }

//a revoir : get mapping can't get an object , only elements
    @GetMapping(path = "{clubid}/events" )
    public List<evenement> geteventsbyClub(@PathVariable("clubid") Long clubid){
    Club club = this.clubService.getclub(clubid);
    return eventService.getClubevent(club);
    }

    @GetMapping(path = "members/{id}/{role}/{page}/{size}")
    public List<Etudiant> getMemberByRole(@PathVariable("role") String role,@PathVariable("id") Long id,@PathVariable("page")int page,@PathVariable("size") int size){
        List<Members> members =this.memberService.getClubMemberRole(id,role,page,size);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));
        }
        return etudiants;
    }

    @GetMapping(path = "GetClubMembers/{idClub}/{page}/{size}")
    public List<studentMember> getClubMembers(@PathVariable("idClub") Long idClub,@PathVariable("page") int page,@PathVariable("size") int size){
    List<Members> members= this.memberService.getClubMembers(idClub,page,size);
    List<Etudiant> etudiants = new ArrayList<>();
    List<studentMember> studentMembers =new ArrayList<>();
        for (Members x: members) {
            etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));
        }
        List<Etudiant> verif=new ArrayList<>();
        for (Etudiant j:etudiants){
            if (!verif.contains(j)){
                verif.add(j);
            }
        }
        for (Members x: members) {
            for (Etudiant y: verif) {
                if (x.getStudentid()==y.getIdE()){studentMembers.add(new studentMember(y.getfullname(),y.getEmail(),x.getRole()));}
            }
        }

        return studentMembers;
    }



//checking if User is Part of the club
    @GetMapping(path = "GetPersonalInfo/{id}")
    @SneakyThrows
    public Members GetPersonalInfo(@PathVariable("id") Long id) {
        Compte compte =this.accountService.getaccoutThroughheader();
        log.info("User {} verifying if he belongs to club {}" ,compte.getEmail(),id);
        boolean Rolee;
        Members members = this.memberService.getMemberbyClubAndStudent(compte.getIdE(),id);
        log.info(members.toString());
        return members;
    }


    @GetMapping(path = "DeleteMember/{email}/{idc}")
    public String Deletemember(@PathVariable("email") String email,@PathVariable("idc") Long idc){
    Compte compte=accountService.getAccountbymail(email);
    if (compte==null) return "Account not found";
    else return memberService.deleteMember(compte.getIdE(),idc);
    }

    @GetMapping(path = "Changepedag/{idpedag}/{idc}")
    public String changepedag(@PathVariable Long idpedag,@PathVariable Long idc){
    return clubService.changepedag(idpedag,idc);
    }

    //*************************************************************************************post mapping*************************************************************************//
    @PostMapping(path = "saveMember")
    public String insertMember(@RequestBody Members member){
        return this.memberService.saveMember(member);

    }

    @PostMapping(path = "Createevent/{id}/{cost}")
    public String CreateEvent(@RequestBody evenement e,@PathVariable("id") Long id,@PathVariable("cost") Long cost){
    if(e==null) return "evenement est null";
        e.setFact(new facture(cost,e.getNomevent()));
        e.setC(clubService.getclub(id));
        log.info(e.toString());
        return  this.eventService.Createevent(e,id);
    }

    @PostMapping(path = "saveComite/{id}")
    public String insertMember(@RequestBody newMember newMember,@PathVariable("id") Long id){
        Compte compte=accountService.getAccountbymail(newMember.getEmail());
        if (compte==null){return"Account not found";}
        Members member = new Members(id,compte.getIdE(),newMember.getRole());
        return this.memberService.saveComite(member);
    }

}
@AllArgsConstructor
class studentMember{
   public String name;
   public String email;
    public String role;
}
