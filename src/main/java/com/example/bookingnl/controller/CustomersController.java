package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.CreateUserUC;
import com.example.bookingnl.bussines.GetUserUC;
import com.example.bookingnl.domain.CreateUserRequest;
import com.example.bookingnl.domain.CreateUserResponse;
import com.example.bookingnl.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomersController {
    private final GetUserUC getUserUC;
    private final CreateUserUC createUserUC;

    @GetMapping()
    public ResponseEntity<User> getUser( String email,  String password) {
        final Optional<User> customerOptional = Optional.ofNullable(getUserUC.getCustomer(email, password));
        if (customerOptional.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customerOptional.get());
    }


    @PostMapping()
    public ResponseEntity<CreateUserResponse> createStudent(@RequestBody  CreateUserRequest request) {
        CreateUserResponse response = createUserUC.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
