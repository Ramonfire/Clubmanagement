package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    List<evenement> findAllByC(Club club);


    Page<evenement> findAllByStateAndType(int i, int i1, Pageable pageable);

    Page<evenement> findAllByType(int type, Pageable pageable);

    Page<evenement> findAllByState(int i, Pageable pageable);

    Page<evenement> findAllByStateAndTypeAndTerminer(int i, int i1, boolean t,Pageable pageable);
}
