package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.CreateUserRequest;
import com.example.bookingnl.domain.CreateUserResponse;

public interface CreateUserUC {
    CreateUserResponse createCustomer(CreateUserRequest request);
}
