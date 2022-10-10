package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.UserService;
import com.example.bookingnl.domain.GetUserRequest;
import com.example.bookingnl.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor

public class CustomersController {
    private UserService service;

    @GetMapping()
    public User getUser(@RequestBody GetUserRequest request) {
       return service.findByEmailAndPassword(request.getEmail(), request.getPassword());
    }

    @CrossOrigin
    @PostMapping()
    public String createStudent(@RequestBody User user) {
        service.save(user);
        return "Well done!";
    }


    @DeleteMapping()
    public String deleteUser(@PathVariable(required = false) String email){
        service.deleteByEmail(email);
        return "User deleted";
    }

    @GetMapping("/getAll")
    public List<User> getUser() {
        return service.findAll();
    }


}
