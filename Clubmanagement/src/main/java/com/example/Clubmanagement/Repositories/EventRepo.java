package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public interface EventRepo extends JpaRepository<evenement,Long> {
    List<evenement> findByState(int etat);
    evenement findByNomevent(String n);
    Long countByState(int etat);
    List<evenement> findByType(int type);

    List<evenement> findAllByC(Club club);

    List<evenement> findByStateAndType(int State,int type);
}
