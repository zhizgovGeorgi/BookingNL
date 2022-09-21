package com.example.bookingnl.persistence;

import com.example.bookingnl.domain.User;

import java.util.Optional;

public interface UserRepository {
    User getUser(String email, String password);
}
