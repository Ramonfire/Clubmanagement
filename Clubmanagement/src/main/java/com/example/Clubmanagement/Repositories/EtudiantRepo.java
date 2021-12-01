package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
Etudiant findByFullname(String nom);
Etudiant findByEmail(String email);
}
