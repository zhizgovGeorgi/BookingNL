package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.persistence.DestinationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DestinationServiceImplTest {
    @Mock
    private DestinationRepository repository;
    @InjectMocks
    private DestinationServiceImpl service;

    private List<Destination> mockData() {
        Destination d1 = Destination.builder()
                .id(1L)
                .name("Kaspichan")
                .location("Location")
                .pricePerNight(18)
                .build();
        Destination d2 = Destination.builder()
                .id(2L)
                .name("Dr name")
                .location("location 2")
                .pricePerNight(18)
                .build();

        List<Destination> destinations = List.of(d1, d2);
        return destinations;
    }

    @Test
    void findAll() {
        List<Destination> destinations = mockData();
        when(repository.findAll()).thenReturn(destinations);
        List<Destination> result = service.findAll();
        assertEquals(destinations, result);
        verify(repository).findAll();
    }

    @Test
    void saveDestination() {

    }

    @Test
    void findById() {
    }

    @Test
    void deleteDestinationById() {
    }
}