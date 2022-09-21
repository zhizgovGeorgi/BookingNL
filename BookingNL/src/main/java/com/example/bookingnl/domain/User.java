package com.example.bookingnl.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String adress;
    private String role;
}
