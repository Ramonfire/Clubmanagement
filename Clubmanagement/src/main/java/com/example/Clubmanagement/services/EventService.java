package com.example.Clubmanagement.services;


import com.example.Clubmanagement.Repositories.EventRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventService {

    private final EventRepo eventrepo;

    public List<evenement> getPevent(int pagenum,int size){
        Pageable pageable = PageRequest.of(pagenum, size);
        Page<evenement> page= this.eventrepo.findAllByStateAndType(1,0,pageable);
        List<evenement> evenements = Arrays.asList(page.getContent().toArray(new evenement[0]));
        return evenements;
}

    public List<evenement> getallevents(int pagenum,int size) {
        Pageable pageable = PageRequest.of(pagenum, size);
        Page<evenement> page= this.eventrepo.findAll(pageable);
        List<evenement> evenements =Arrays.asList(page.getContent().toArray(new evenement[0]));
        return evenements; }

    public Long Countevents(int etat) {
        return eventrepo.countByState(etat);
    }

    public List<evenement> geteventbytype(int type,int pagenum,int size) {
        Pageable pageable = PageRequest.of(pagenum, size);
        Page<evenement> page= this.eventrepo.findAllByType(type,pageable);
        List<evenement> evenements = Arrays.asList(page.getContent().toArray(new evenement[0]));
        return evenements;

    }

    public List<evenement> getClubevent(Club club) {
        return this.eventrepo.findAllByC(club);


    }

    public List<evenement> geteventbyState(int i, int pagenum,int size) {
        Pageable pageable = PageRequest.of(pagenum, size);
        Page<evenement> page= this.eventrepo.findAllByState(i,pageable);
        List<evenement> evenements = Arrays.asList(page.getContent().toArray(new evenement[0]));
        return evenements;

    }

    public evenement geteventByname(String name) {
      return  this.eventrepo.findByNomevent(name);
    }


}
