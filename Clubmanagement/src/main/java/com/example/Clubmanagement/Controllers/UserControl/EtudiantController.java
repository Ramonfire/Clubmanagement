package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.services.DemandeService;
import com.example.Clubmanagement.services.EventService;
import com.example.Clubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Clubpage/student")
public class EtudiantController {
    private final DemandeService demandeService;
    private final MemberService memberService;
    private final EventService eventService;

@Autowired
    public EtudiantController(DemandeService demandeService, MemberService memberService, EventService eventService) {
        this.demandeService = demandeService;
        this.memberService = memberService;
        this.eventService = eventService;
    }

    @GetMapping(path = "MesDemandes")
    public List<CreationDemand> Mesdemandes(Long idE){
    return this.demandeService.getEtudiantDemande(idE);
}

@GetMapping(path = "plannedevents")
public List<evenement> getconfirmedevents(){
        return this.eventService.geteventbyState(1);
}

//****************************************************************post mapping*****************************************************************************************//
@PostMapping(path = "newDemande")
    public CreationDemand newDemande(@RequestBody CreationDemand demand){
return this.demandeService.saveDemande(demand);

}

@PostMapping(path = "joinClub{")
    public Members JoinClub(@RequestBody Members members){
        return memberService.SaveNewMember(members);

}



}
