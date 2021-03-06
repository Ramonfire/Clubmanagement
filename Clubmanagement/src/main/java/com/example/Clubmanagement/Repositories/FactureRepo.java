package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.facture;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface FactureRepo extends JpaRepository<facture,Long> {
    facture findByEventname(String eventname);
}
