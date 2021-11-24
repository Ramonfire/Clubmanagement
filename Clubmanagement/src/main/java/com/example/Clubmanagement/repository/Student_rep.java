package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_rep extends JpaRepository<Etudiant,Long> {
}
