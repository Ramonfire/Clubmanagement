package com.example.Clubmanagement.Services;


import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import com.example.Clubmanagement.repository.Club_rep;
import com.example.Clubmanagement.repository.Event_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_general {

private final Event_rep event_rep;
private final Club_rep club_rep;

//constructor
@Autowired
    public Service_general(Event_rep event_rep, Club_rep club_rep) {
        this.event_rep = event_rep;
        this.club_rep = club_rep;
}
//***********************************************************


//getting all events and clubs
    public List<evenement> getallevents() {return event_rep.findAll();}
    public List<Club>      getallclubs()  {return club_rep.findAll();}



}
