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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "Club")
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



    @GetMapping(path = "{Clubid}/members")
public List<Etudiant> getAllStudents(@PathVariable("Clubid") Long Clubid){
    List<Members> members =this.memberService.getClubMembers(Clubid);
        List<Etudiant> etudiants = new ArrayList<>();
        for (Members x: members) {
             etudiants.add(this.etudiantService.getStudentbyid(x.getStudentid()));

        }
    return etudiants;
    }


    @GetMapping(path = "events/{type}")
    public List<evenement> geteventsbytype(@PathVariable int type){

    return this.eventService.geteventbytype(type);

    }
//a revoir : get mapping can't get an object , only elements
    @GetMapping(path = "{clubid}/events" )
    public List<evenement> geteventsbyClub(@PathVariable("clubid") Long clubid){

    Club club = this.clubService.getclub(clubid);

    return eventService.getClubevent(club);
    }

    @GetMapping(path = "members/{id}/{role}")
    public List<Etudiant> getMemberByRole(@PathVariable("role") String role,@PathVariable("id") Long id){
        List<Members> members =this.memberService.getClubMember(id,role);
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