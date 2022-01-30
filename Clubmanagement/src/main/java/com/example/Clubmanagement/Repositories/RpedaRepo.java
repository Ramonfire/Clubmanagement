package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.generlAc.Rpedag;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface RpedaRepo extends JpaRepository<Rpedag,Long> {
    Rpedag findByIdE(Long id);
}
