package com.example.bookingnl.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DestinationTest {

    @Test
    void testSetPricePerNight() throws Exception {
        Destination destination = new Destination();
        destination.setPricePerNight(10.0d);
        assertEquals(10.0d, destination.getPricePerNight());
    }


    @Test
    void testSetPricePerNight2() throws Exception {
        assertThrows(Exception.class, () -> (new Destination()).setPricePerNight(0.0d));
    }
}

