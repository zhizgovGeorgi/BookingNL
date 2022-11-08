package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.persistence.DestinationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository repository;
    @Override
    public Optional<List<Destination>> getAllDestinations() {
        return Optional.of(repository.findAll());
    }

    @Override
    public Optional<Destination> createDestination(Destination destination) {
        return Optional.empty();
    }

    @Override
    public void deleteDestination(Destination destination) {

    }
}
