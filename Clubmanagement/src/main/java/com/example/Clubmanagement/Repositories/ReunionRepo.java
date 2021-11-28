package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.club.reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionRepo extends JpaRepository<reunion,Long> {
}
