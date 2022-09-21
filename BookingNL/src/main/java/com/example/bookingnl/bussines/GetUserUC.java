package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.User;

public interface GetUserUC {
    User getCustomer(String email, String password);
}
