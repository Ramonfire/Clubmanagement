package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.Club;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public interface ClubRepo extends JpaRepository<Club,Long> {
    Club findAllByNomclub(String nom);
    List<Club> findByEtat(boolean etat);
    Club findByIdc (Long id);
    
}
