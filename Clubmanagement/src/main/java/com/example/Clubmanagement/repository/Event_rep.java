package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.club.evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Event_rep extends JpaRepository<evenement,Long> {
}
