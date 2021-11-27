package com.example.Clubmanagement.UserControl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface User_rep extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByEmailAndPassword(String email,String password);
}
