package com.example.Clubmanagement.Controllers.UserControl;


import com.example.Clubmanagement.entities.Forms.CreationDemand;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.services.DemandeService;
import com.example.Clubmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "Clubpage/admin")
public class AdminControl {

    private  EventService eventService;
    private DemandeService demandeService;

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
    public List<CreationDemand> getDemandebyState(@PathVariable("etat") Boolean etat ){
    return demandeService.getdemandeBystate(etat);

    }


}
