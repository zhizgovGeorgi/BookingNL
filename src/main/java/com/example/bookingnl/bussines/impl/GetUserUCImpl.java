package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.GetUserUC;
import com.example.bookingnl.domain.User;
import org.springframework.stereotype.Service;

@Service
public class GetUserUCImpl implements GetUserUC {
    @Override
    public User getCustomer(String email, String password) {
        return new User();
    }
}
