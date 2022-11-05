package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.UserService;
import com.example.bookingnl.domain.GetUserRequest;
import com.example.bookingnl.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin
public class CustomersController {
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());
        return ResponseEntity.created(uri).body(service.save(user));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);

    }

    @DeleteMapping()
    public String deleteUser(@PathVariable(required = false) String email) {
        service.deleteByEmail(email);
        return "User deleted";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUser() {

        return ResponseEntity.ok().body(service.findAll());
    }


}
