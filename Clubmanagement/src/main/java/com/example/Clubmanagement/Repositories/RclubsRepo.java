package com.example.Clubmanagement.Repositories;


import com.example.Clubmanagement.entities.compte.generlAc.Rclubs;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface RclubsRepo extends JpaRepository<Rclubs,Long> {
}
