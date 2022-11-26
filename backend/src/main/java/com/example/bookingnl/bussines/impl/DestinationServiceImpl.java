package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.persistence.DestinationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository repository;

    @Override
    public List<Destination> findAll() {
        return repository.findAll();
    }

    @Override
    public Destination saveDestination(Destination destination) {
        if (repository.findByNameAndLocation(destination.getName(), destination.getLocation()) != null) {

            return repository.save(destination);
        }
        return null;
    }



    @Override
    public Optional<Destination> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteDestinationById(long id) throws Exception {
        if (repository.findById(id) != null) {
            repository.deleteDestinationById(id);
        }
        else {
            throw new Exception("You have not selected a destination to be deleted!");
        }
    }
}
