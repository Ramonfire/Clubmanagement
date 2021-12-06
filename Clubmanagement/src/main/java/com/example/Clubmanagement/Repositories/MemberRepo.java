package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public interface MemberRepo extends JpaRepository<Members,Long> {
    List<Members> findByRole(String role);
    List<Members> findByClubid(Long Id);


}
