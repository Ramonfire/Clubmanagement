package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Event_rep extends JpaRepository<evenement,Long> {

    List<evenement> findByType(int type);
    List<evenement> findByName(String name);
    List<evenement> findByState(int etat);


}
