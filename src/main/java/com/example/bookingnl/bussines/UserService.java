package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    UserDetails loadUserByUsername(String username);
    User findByEmailAndPassword (String email, String password);
    void deleteByEmail(String email);
    User save(User user);
    List<User> findAll ();
}
