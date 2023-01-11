package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.exceptions.DuplicationException;
import com.example.bookingnl.exceptions.InvalidData;
import com.example.bookingnl.exceptions.UnauthorizedException;
import com.example.bookingnl.persistence.DestinationRepository;
import com.example.bookingnl.persistence.UserRepository;
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
    public Destination saveDestination(Destination destination) throws DuplicationException {

        if (repository.findByNameAndLocation(destination.getName(), destination.getLocation()).isEmpty()) {

            return repository.save(destination);
        }
        throw new DuplicationException();
    }


    @Override
    public Optional<Destination> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteDestinationById(Long id) throws Exception {
//
        if (repository.findById(id) != null) {
            repository.deleteDestinationById(id);
        } else {
            throw new Exception("You have not selected a destination to be deleted!");
        }
    }
}
