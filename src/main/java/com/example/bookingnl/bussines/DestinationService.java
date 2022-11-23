package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.CreateDestinationRequest;
import com.example.bookingnl.domain.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationService {
    Destination saveDestination(CreateDestinationRequest request);


    Optional<Destination> findById(long id);

    void deleteDestinationById(long id);

    List<Destination> findAll();
}
