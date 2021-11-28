package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.generlAc.R_pedag;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface R_pedaRepo extends JpaRepository<R_pedag,Long> {
}
