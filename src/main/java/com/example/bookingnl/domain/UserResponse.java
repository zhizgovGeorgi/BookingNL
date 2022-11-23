package com.example.bookingnl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

        private String firstName;
        private String lastName;
        private String email;
        private String adress;
        private String role;

}
