package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.Club;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface ClubRepo extends JpaRepository<Club,Long> {
    Club findByNomclub(String nom);
}
