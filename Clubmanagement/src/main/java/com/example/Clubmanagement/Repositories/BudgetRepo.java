package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepo extends JpaRepository<budget,Long> {
}
