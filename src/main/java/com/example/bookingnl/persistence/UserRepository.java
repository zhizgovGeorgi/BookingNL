package com.example.bookingnl.persistence;

import com.example.bookingnl.domain.CreateUserRequest;
import com.example.bookingnl.domain.CreateUserResponse;
import com.example.bookingnl.domain.User;

import java.util.Optional;

public interface UserRepository {
    User getUser(String email, String password);
    CreateUserResponse createCustomer(CreateUserRequest request);
}
