package com.example.Clubmanagement.UserControl.UserService;

import com.example.Clubmanagement.UserControl.Role;
import com.example.Clubmanagement.UserControl.User;

import java.util.List;

public interface User_service {

    User saveUser(User u);
    Role saveRole(Role role);
    void addRoletoUser(String email, String role);
    User getUser(String email);
    List<User> getUsers();
}
