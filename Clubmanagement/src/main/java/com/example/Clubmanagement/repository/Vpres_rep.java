package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.compte.Clubsmembers.Vpres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vpres_rep extends JpaRepository<Vpres,Long> {
}
