package com.example.Clubmanagement.UserControl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Role_repo extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
