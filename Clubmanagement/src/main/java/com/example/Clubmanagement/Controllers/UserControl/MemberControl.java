package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.EtudiantService;
import com.example.Clubmanagement.services.EventService;
import com.example.Clubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "Clubpage/member")
public class MemberControl {
     private final MemberService memberService;
     private final EtudiantService etudiantService;
     private final ClubService clubService;
     private final EventService eventService;




@Autowired
    public MemberControl(MemberService memberService, EtudiantService etudiantService, ClubService clubService, EventService eventService) {
        this.memberService = memberService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
    this.eventService = eventService;
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
    //*************************************************************************************post mapping*************************************************************************//
    @PostMapping(path = "saveMember")
    public String insertMember(@RequestBody Members member){
        return this.memberService.saveMember(member);

    }



}
