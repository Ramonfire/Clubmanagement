package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.compte.Clubsmembers.pres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pres_rep extends JpaRepository<pres,Long> {
}
