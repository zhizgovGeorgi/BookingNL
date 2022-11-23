package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.CreateUserRequest;
import com.example.bookingnl.domain.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    User save(CreateUserRequest request);

}
