package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.EtudiantService;
import com.example.Clubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "Club")
public class MemberControl {
     private MemberService memberService;
     private EtudiantService etudiantService;
     private ClubService clubService;




@Autowired
    public MemberControl(MemberService memberService, EtudiantService etudiantService, ClubService clubService) {
        this.memberService = memberService;
    this.etudiantService = etudiantService;
    this.clubService = clubService;
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


    @PostMapping(path = "saveMember")
    public String insertMember(@RequestBody Members member){
        return this.memberService.saveMember(member);

    }

}
