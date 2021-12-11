package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Compte,Long> {
Compte findByEmail(String email);
}
