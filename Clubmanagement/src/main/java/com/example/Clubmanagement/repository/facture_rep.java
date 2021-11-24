package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.club.facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface facture_rep extends JpaRepository<facture,Long> {
}
