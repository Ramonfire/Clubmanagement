package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface Member_repo extends JpaRepository<Members,Long> {
    Members findByRole(String role);
    Members findByClubid(Long Id);
}
