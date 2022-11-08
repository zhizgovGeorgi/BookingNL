package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationService {
    Optional<List<Destination>> getAllDestinations();
    Optional<Destination> createDestination(Destination destination);
    void deleteDestination(Destination destination);
}
