package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.User;

import java.util.List;

public interface UserService {
    User findByEmailAndPassword (String email, String password);
    void deleteByEmail(String email);
    User save(User user);
    List<User> findAll ();
}
