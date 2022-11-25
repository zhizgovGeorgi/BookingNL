package com.example.bookingnl.converter;

import com.example.bookingnl.controller.CreateUserRequest;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.controller.UserResponse;


public  class UserConverter {


    public static User requestToEntity(CreateUserRequest request){
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .adress(request.getAdress())
                .build();
        return  user;
    }

    public static UserResponse entityToResponse(User user){
        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .build();
        return  response;
    }
}