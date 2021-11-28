package com.example.Clubmanagement.Repositories;


import com.example.Clubmanagement.entities.compte.generlAc.R_clubs;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface R_ClubsRepo extends JpaRepository<R_clubs,Long> {
}
