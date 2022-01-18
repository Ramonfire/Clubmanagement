package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.Forms.CreationDemand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface DemandeRepo extends JpaRepository<CreationDemand,Long> {

    Page<CreationDemand> findAllByEtatD(int etat, Pageable pageable);
    List<CreationDemand> getAllByIdEtudiant(Long idE);

    int countAllByEtatD(int etatD);
}
