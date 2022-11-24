package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.converter.DestinationConverter;
import com.example.bookingnl.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinations")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@Transactional
public class DestinationController {
    private final DestinationService service;


    @GetMapping()
    public ResponseEntity<List<Destination>> getDestinations() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<DestinationResponse> saveDestination(@RequestBody CreateDestinationRequest request) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/destinations").toUriString());
        Destination destination = DestinationConverter.requestToEntity(request);
        DestinationResponse response = DestinationConverter.entityToResponse(service.saveDestination(destination));
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("{id}")
    public Optional<Destination> getDestination(@PathVariable(value = "id") final long id) {
        return ResponseEntity.ok().body(service.findById(id)).getBody();

    }

    @DeleteMapping("{id}")
    public String deleteDestination(@PathVariable(value = "id") final long id) {
        service.deleteDestinationById(id);
        return "Successful deletion";
    }
}
