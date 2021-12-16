package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public interface ClubRepo extends JpaRepository<Club,Long> {
    Club findAllByNomclub(String nom);
    List<Club> findByEtat(boolean etat);
    Club findByIdc (Long id);
    Page<Club> findAllByStudents(Etudiant student, Pageable pageable);

    Page<Club> findAllByEtat(boolean etat, Pageable pageable);
}
