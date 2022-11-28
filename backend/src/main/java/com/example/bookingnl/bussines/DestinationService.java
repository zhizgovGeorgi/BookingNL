package com.example.bookingnl.bussines;

import com.example.bookingnl.domain.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationService {
    Destination saveDestination(Destination destination);


    Optional<Destination> findById(Long id);

    void deleteDestinationById(Long id) throws Exception;

    List<Destination> findAll();
}
