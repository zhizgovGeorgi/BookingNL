package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.CreateUserRequest;
import com.example.bookingnl.domain.User;


public interface UserService {
    User findByEmail(String email);

    User save(User user);

}
