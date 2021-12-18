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
import com.example.Clubmanagement.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
@RequestMapping(path = "Clubpage/student")
@RequiredArgsConstructor
public class EtudiantController {
    private final DemandeService demandeService;
    private final MemberService memberService;
    private final EventService eventService;
    private final ClubService clubService;
    private final AccountService accountService;
//get header - get user - get member - view athority in club then act!

    @GetMapping(path = "MesDemandes")
    public List<CreationDemand> Mesdemandes(Long idE) {
        return this.demandeService.getEtudiantDemande(idE);
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


    //****************************************************************post mapping*****************************************************************************************//
    @PostMapping(path = "newDemande")
    public CreationDemand newDemande(@RequestBody CreationDemand demand) {
        return this.demandeService.saveDemande(demand);

    }

    @PostMapping(path = "joinClub")
    public String JoinClub(@RequestBody Members members) {
        return memberService.saveMember(members);

    }
}


