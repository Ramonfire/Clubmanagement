package com.example.Clubmanagement.repository;

import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Members_rep extends JpaRepository<Members,Long> {

}
