package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.compte.generlAc.R_clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_clubs_rep extends JpaRepository<R_clubs,Long> {
}
