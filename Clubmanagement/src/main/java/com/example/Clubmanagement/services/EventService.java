package com.example.Clubmanagement.services;


import com.example.Clubmanagement.Repositories.ClubRepo;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventService {

    private final EventRepo eventrepo;
    public final ClubRepo clubRepo;

    public List<evenement> getPevent(int pagenum,int size){
        Pageable pageable = PageRequest.of(pagenum, size);
        Page<evenement> page= this.eventrepo.findAllByStateAndTypeAndTerminer(1,0,false,pageable);
        List<evenement> evenements = Arrays.asList(page.getContent().toArray(new evenement[0]));
        return evenements;
}

    public List<evenement> getallevents(int pagenum,int size) {
        Pageable pageable = PageRequest.of(pagenum, size);
        Page<evenement> page= this.eventrepo.findAllByTerminer(false,pageable);
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
        Page<evenement> page= this.eventrepo.findAllByStateAndTerminer(i,false,pageable);
        List<evenement> evenements = Arrays.asList(page.getContent().toArray(new evenement[0]));
        return evenements;

    }

    public evenement geteventByname(String name) {
      return  this.eventrepo.findByNomevent(name);
    }


    public Optional<evenement> getEventById(Long id) {return this.eventrepo.findById(id);
    }

    public String ChangeEventState(Long id,int i) {
        String response="error";
        evenement e=eventrepo.findByIdevent(id);
        if (e==null){
            response="event Not found";
        }else{
            e.setState(i);
            eventrepo.save(e);
            if (i==1){
                response="accepted!";
                e.getC().setBudget(e.getC().getBudget() - e.getFact().getFrais());
                clubRepo.save(e.getC());
            }else{response="done";}
        }
        return response ;
    }

    public String Createevent(evenement e,Long id) {
        String response="error";
        evenement test = eventrepo.findByNomeventAndTerminer(e.getNomevent(),false);
        Club club =clubRepo.findByIdc(id);
        if (test==null){
            e.setC(club);
            eventrepo.save(e);
            response="Successfully saved event";
        }else response="Event under this name already exists";

        return response;
    }

    public String ChangeTerminer(Long terminer) {
        evenement evenement=eventrepo.findByIdevent(terminer);
        if (evenement==null)return "event not found";
        else {
            evenement.setTerminer(true);
            eventrepo.save(evenement);
            return "event terminated";
        }
    }
}
