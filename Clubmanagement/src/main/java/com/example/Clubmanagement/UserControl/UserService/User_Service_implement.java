package com.example.Clubmanagement.UserControl.UserService;

import com.example.Clubmanagement.UserControl.Role;
import com.example.Clubmanagement.UserControl.Role_repo;
import com.example.Clubmanagement.UserControl.User;
import com.example.Clubmanagement.UserControl.User_rep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class User_Service_implement implements  User_service {
private final User_rep user_rep;
private final Role_repo role_repo;


    @Override
    public User saveUser(User user) {
        return User_rep.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return Role_repo.save(role);
    }

    @Override
    public void addRoletoUser(String email, String role) {
            User user=User_rep.findByEmail(email);
    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
