package com.example.bookingnl.domain;

import com.example.bookingnl.controller.CreateUserRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {


    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setAdress("Adress");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(123L);
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        actualUser.setRole("Role");
        assertEquals("Adress", actualUser.getAdress());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Role", actualUser.getRole());
    }
}
