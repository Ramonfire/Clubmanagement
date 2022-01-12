package com.example.Clubmanagement.Controllers.UserControl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.Clubmanagement.Generalmethode;
import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import com.example.Clubmanagement.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "Clubpage/student")
@RequiredArgsConstructor
@Slf4j
public class EtudiantController {
    private final DemandeService demandeService;
    private final MemberService memberService;
    private final EventService eventService;
    private final ClubService clubService;
    private final AccountService accountService;
    private  final  RclubsService rclubsService;
//get header - get user - get member - view athority in club then act!

    @SneakyThrows
    @GetMapping(path = "MesDemandes")
    public List<CreationDemand> Mesdemandes()  {
        Compte etudiant = accountService.getaccoutThroughheader();
        return this.demandeService.getEtudiantDemande(etudiant.getIdE());
    }

    @GetMapping(path = "plannedevents/{pagenum}/{size}")
    public List<evenement> getconfirmedevents(@PathVariable int pagenum,@PathVariable int size) {
        return this.eventService.geteventbyState(1,pagenum,size);
    }


    //******getting someone's clubs******//
    @SneakyThrows
    @GetMapping(path = "Myclubs/{pagenum}/{size}")
    public List<Club> getmesclub(@PathVariable(value = "pagenum", required = false ) int pagenum, @PathVariable(value = "size" ,required = false) int size) {
        Compte compte = this.accountService.getaccoutThroughheader();

        if (compte != null && compte instanceof Etudiant) {
            Etudiant etudiant = (Etudiant) compte;
            return clubService.GetMembersClub(etudiant,pagenum,size);
        }else return null;
    }
//studentpage events

    @GetMapping("events/{name}")
    public evenement getEventByname(@PathVariable("name") String name){
        return this.eventService.geteventByname(name);
    }

    @GetMapping(path ="allclubs/{page}/{size}")
    public List<Club> getallActiveClubs(@PathVariable(name = "page") int page,@PathVariable("size") int size){
        return clubService.getAllActiveClub(page,size);
    }
    @GetMapping(path = "Club/{id}")
    public Club getclub(@PathVariable("id") Long id){
        return clubService.getclub(id);
    }

    @GetMapping(path = "mot")
    public String getclub(){
        return rclubsService.returnMot();
    }

    @SneakyThrows
    @GetMapping("AccountType")
    public String getAccountType(){
        Compte compte =accountService.getaccoutThroughheader();
        if (compte instanceof Etudiant){
            return "S";
        }
        else if (compte instanceof Rclubs){
            return  "Rc";}
        else return "Rp";
    }


@GetMapping("MyClubCount")
@SneakyThrows
public int ClubCount(){
        Compte compte = accountService.getaccoutThroughheader();
        return memberService.getClubCount(compte.getIdE());
}




    //****************************************************************post mapping*****************************************************************************************//
    @PostMapping(path = "newDemande")
    public CreationDemand newDemande(@RequestBody CreationDemand demand) {
        return this.demandeService.saveDemande(demand);

    }
    //not working to be reviewed  . object are Null
    @SneakyThrows
    @PostMapping(path = "joinClub", consumes = "*/*")
    public String JoinClub( Members members) {
        log.info("got member Clubid:{}  Studentid:{}  role :{}", members.getClubid(),members.getStudentid(),members.getRole());
        Compte compte = accountService.getaccoutThroughheader();
        members.setStudentid(compte.getIdE());
        if (members.getClubid()==null || members.getStudentid()==null){return "club id  or student id is null";}
        else {
            log.info("member saved here Clubid:{}  Studentid:{} role {}", members.getClubid(),members.getStudentid(),members.getRole());
            return memberService.saveMember(members);}

    }


}


