package com.example.bookingnl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserResponseTest {
    /**
     * Method under test: {@link UserResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress")).canEqual("Other"));
    }

    /**
     * Method under test: {@link UserResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress");
        assertTrue(userResponse.canEqual(new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#UserResponse(Long, String, String, String, String)}
     *   <li>{@link UserResponse#setAdress(String)}
     *   <li>{@link UserResponse#setEmail(String)}
     *   <li>{@link UserResponse#setFirstName(String)}
     *   <li>{@link UserResponse#setId(Long)}
     *   <li>{@link UserResponse#setLastName(String)}
     *   <li>{@link UserResponse#toString()}
     *   <li>{@link UserResponse#getAdress()}
     *   <li>{@link UserResponse#getEmail()}
     *   <li>{@link UserResponse#getFirstName()}
     *   <li>{@link UserResponse#getId()}
     *   <li>{@link UserResponse#getLastName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserResponse actualUserResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress");
        actualUserResponse.setAdress("Adress");
        actualUserResponse.setEmail("jane.doe@example.org");
        actualUserResponse.setFirstName("Jane");
        actualUserResponse.setId(123L);
        actualUserResponse.setLastName("Doe");
        String actualToStringResult = actualUserResponse.toString();
        assertEquals("Adress", actualUserResponse.getAdress());
        assertEquals("jane.doe@example.org", actualUserResponse.getEmail());
        assertEquals("Jane", actualUserResponse.getFirstName());
        assertEquals(123L, actualUserResponse.getId().longValue());
        assertEquals("Doe", actualUserResponse.getLastName());
        assertEquals("UserResponse(id=123, firstName=Jane, lastName=Doe, email=jane.doe@example.org, adress=Adress)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"), null);
        assertNotEquals(new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"),
                "Different type to UserResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress");
        assertEquals(userResponse, userResponse);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress");
        UserResponse userResponse1 = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress");

        assertEquals(userResponse, userResponse1);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse1.hashCode());
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        UserResponse userResponse = new UserResponse(1L, "Jane", "Doe", "jane.doe@example.org", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserResponse userResponse = new UserResponse(null, "Jane", "Doe", "jane.doe@example.org", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserResponse userResponse = new UserResponse(123L, "Doe", "Doe", "jane.doe@example.org", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        UserResponse userResponse = new UserResponse(123L, null, "Doe", "jane.doe@example.org", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Jane", "jane.doe@example.org", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        UserResponse userResponse = new UserResponse(123L, "Jane", null, "jane.doe@example.org", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", "Jane", "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", null, "Adress");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Jane");
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Method under test: {@link UserResponse#equals(Object)}
     */
    @Test
    void testEquals13() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", null);
        assertNotEquals(userResponse, new UserResponse(123L, "Jane", "Doe", "jane.doe@example.org", "Adress"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        UserResponse userResponse = new UserResponse(null, "Jane", "Doe", "jane.doe@example.org", "Adress");
        UserResponse userResponse1 = new UserResponse(null, "Jane", "Doe", "jane.doe@example.org", "Adress");

        assertEquals(userResponse, userResponse1);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        UserResponse userResponse = new UserResponse(123L, null, "Doe", "jane.doe@example.org", "Adress");
        UserResponse userResponse1 = new UserResponse(123L, null, "Doe", "jane.doe@example.org", "Adress");

        assertEquals(userResponse, userResponse1);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals16() {
        UserResponse userResponse = new UserResponse(123L, "Jane", null, "jane.doe@example.org", "Adress");
        UserResponse userResponse1 = new UserResponse(123L, "Jane", null, "jane.doe@example.org", "Adress");

        assertEquals(userResponse, userResponse1);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserResponse#equals(Object)}
     *   <li>{@link UserResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        UserResponse userResponse = new UserResponse(123L, "Jane", "Doe", null, "Adress");
        UserResponse userResponse1 = new UserResponse(123L, "Jane", "Doe", null, "Adress");

        assertEquals(userResponse, userResponse1);
        int expectedHashCodeResult = userResponse.hashCode();
        assertEquals(expectedHashCodeResult, userResponse1.hashCode());
    }
}

