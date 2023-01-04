package com.example.bookingnl.domain;

import com.example.bookingnl.controller.CreateUserRequest;
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


    private User createUser() {
        User user = User.builder().id(2L).firstName("petar").lastName("behcet").adress("street").email("bobby@gmail.com").password("ahmed-3").build();
        return user;
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAdress(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRole(String)}
     *   <li>{@link User#getAdress()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRole()}
     * </ul>
     */
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
