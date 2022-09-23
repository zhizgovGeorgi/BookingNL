package com.example.bookingnl.persistence.impl;

import com.example.bookingnl.domain.CreateUserRequest;
import com.example.bookingnl.domain.CreateUserResponse;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.persistence.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {


    private static long NEXT_ID = 1;
    private final List<User> savedUsers;

    public UserRepositoryImpl() {
        this.savedUsers = new ArrayList<>();
    }



    @Override
    public User findByEmailAndPassword(String email, String password) {
        return this.savedUsers.stream()
                .filter(studentEntity -> studentEntity.getId().equals(studentId))
                .findFirst();

    @Override
    public CreateUserResponse createCustomer(CreateUserRequest request) {
        return null;
    }
}
