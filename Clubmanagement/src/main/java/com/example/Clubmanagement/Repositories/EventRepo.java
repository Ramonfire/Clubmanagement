package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<evenement,Long> {
    evenement findByState(int etat);
    evenement findByNomevent(String n);
}
