package com.example.bookingnl.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    CreateUserRequest user = CreateUserRequest.builder().firstName(createUser().getFirstName()).lastName(createUser().getLastName()).adress(createUser().getAdress()).email(createUser().getEmail()).password(createUser().getPassword()).build();

    @Test
    void getName() {
        String actual = user.getFirstName();
        String expected = "petar";
        assertEquals(actual, expected);
    }

    @Test
    void getLastName() {
        String actual = user.getLastName();
        String expected = "behcet";
        assertEquals(actual, expected);
    }

    @Test
    void getAdress() {
        String actual = user.getAdress();
        String expected = "street";
        assertEquals(actual, expected);
    }

    @Test
    void getEmail() {
        String actual = user.getEmail();
        String expected = "bobby@gmail.com";
        assertEquals(actual, expected);
    }

    @Test
    void getPassword() {
        String actual = user.getPassword();
        String expected = "ahmed-3";
        assertEquals(actual, expected);
    }

   /* @Test
    void getRole() {
        String actual = user.getRole();
        String expected = "admin";
        assertEquals(actual, expected);
    }*/

    private User createUser(){
        User user = User.builder().id(2L).firstName("petar").lastName("behcet").adress("street").email("bobby@gmail.com").password("ahmed-3").build();
        return user;
    }
}
