package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.Forms.CreationDemand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface DemandeRepo extends JpaRepository<CreationDemand,Long> {

    List<CreationDemand> findByEtatD(boolean etat);
}
