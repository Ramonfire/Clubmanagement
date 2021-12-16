package com.example.Clubmanagement.services;


import com.example.Clubmanagement.Repositories.EventRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventService {

    private final EventRepo eventrepo;

    public List<evenement> getPevent(){
        return this.eventrepo.findByStateAndType(1,0);
}

    public List<evenement> getallevents() { return eventrepo.findAll(); }

    public Long Countevents(int etat) {
        return eventrepo.countByState(etat);
    }

    public List<evenement> geteventbytype(int type) {
        return this.eventrepo.findByType(type);
    }

    public List<evenement> getClubevent(Club club) {
        return this.eventrepo.findAllByC(club);


    }

    public List<evenement> geteventbyState(int i) {
        return this.eventrepo.findByState(i);
    }

    public evenement geteventByname(String name) {
      return  this.eventrepo.findByNomevent(name);
    }

    public evenement geteventByid(Long id) {
        return this.eventrepo.findById_event(id);
    }
}
