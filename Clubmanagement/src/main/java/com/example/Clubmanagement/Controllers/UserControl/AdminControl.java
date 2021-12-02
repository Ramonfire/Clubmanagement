package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.services.ClubService;
import com.example.Clubmanagement.services.DemandeService;
import com.example.Clubmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Clubpage/admin")
public class AdminControl {

    private  EventService eventService;
    private DemandeService demandeService;
    private ClubService clubService;

@Autowired
    public AdminControl(EventService eventService, DemandeService demandeService) {
        this.eventService = eventService;
    this.demandeService = demandeService;
}

    @GetMapping(path = "events")
    public List<evenement> getallevents(){
    return eventService.getallevents();
    }

    @GetMapping(path = "allclubs")
    public List<CreationDemand> getallDemands(){
    return demandeService.getAllDemands();
    }

    @GetMapping(value = "demandeclub/{etat}")
    public List<CreationDemand> getDemandebyState(@PathVariable("etat") boolean etat ){
    return demandeService.getdemandeBystate(etat);

    }
    @GetMapping(path = "publicevent")
    public List<evenement> getPublicevents(){
        return  eventService.getPevent();

    }
    @GetMapping(path ="allclubs/{etat}")
    public List<Club> getallClubs(@PathVariable("etat") boolean etat ){
        return clubService.getAllClubs(etat);
    }


}
