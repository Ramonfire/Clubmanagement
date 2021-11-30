package com.example.Clubmanagement.services;


import com.example.Clubmanagement.Repositories.EventRepo;
import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepo eventrepo;

    @Autowired

    public EventService(EventRepo eventrepo) {
        this.eventrepo = eventrepo;
    }

public List<evenement> getPevent(){
        return this.eventrepo.findByState(0);
}

}
