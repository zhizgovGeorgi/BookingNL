package com.example.bookingnl.domain;

import com.example.bookingnl.controller.CreateUserRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {


    @Test
    void userConstructor() {
        User actualUser = new User();
        actualUser.setAdress("Adress");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(123L);
        actualUser.setLastName("Doe");
        actualUser.setPassword("1234");
        actualUser.setRole("Role");
        assertEquals("Adress", actualUser.getAdress());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("1234", actualUser.getPassword());
        assertEquals("Role", actualUser.getRole());
    }

}
