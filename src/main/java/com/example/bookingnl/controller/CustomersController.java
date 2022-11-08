package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.UserService;
import com.example.bookingnl.domain.GetUserRequest;
import com.example.bookingnl.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin
public class CustomersController {
    private UserService service;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {

        return ResponseEntity.ok().body(service.findAll());
    }


    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());
        return  ResponseEntity.created(uri).body(service.save(user));
    }

    /*@PostMapping("/login")
    public String logIn(@RequestBody GetUserRequest request) {
        //URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());
        // return ResponseEntity.created(uri).body(service.save(user));
        if (service.findByEmailAndPassword(request.getEmail(), request.getPassword()) != null){
            return "Welcome!";
        }
        return "Wrong credentials, try again!";
    }*/



    @DeleteMapping()
    public String deleteUser(@PathVariable(required = false) String email) {
        service.deleteByEmail(email);
        return "User deleted";
    }


}
