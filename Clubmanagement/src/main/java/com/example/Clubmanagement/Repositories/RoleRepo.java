package com.example.Clubmanagement.Repositories;

import com.example.Clubmanagement.entities.compte.generlAc.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
