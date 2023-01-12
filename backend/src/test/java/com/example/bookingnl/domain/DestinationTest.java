package com.example.bookingnl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DestinationTest {
    @Test
    void destinationTestConstructor() throws Exception {
        Destination actualDestination = new Destination();
        actualDestination.setName("Pakistan");
        actualDestination.setLocation("Pakistan1");
        actualDestination.setId(123L);
        actualDestination.setPricePerNight(10.0d);
        assertEquals("Pakistan", actualDestination.getName());
        assertEquals("Pakistan1", actualDestination.getLocation());
        assertEquals(123L, actualDestination.getId().longValue());
        assertEquals(10.0d, actualDestination.getPricePerNight());
    }


    @Test
    void testSetPricePerNight() throws Exception {
        Destination destination = new Destination();
        destination.setPricePerNight(10.0d);
        assertEquals(10.0d, destination.getPricePerNight());
    }


    @Test
    void testSetPricePerNight_when_price_is_zero() throws Exception {
        assertThrows(Exception.class, () -> (new Destination()).setPricePerNight(0.0d));
    }
}

