package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Club_rep extends JpaRepository<Club,Long> {
    List<Club> findByEtat(boolean etat);
}
