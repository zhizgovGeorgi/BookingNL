package controller;

import bussines.GetCustomerUC;
import domain.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomersController {
    private final GetCustomerUC getCustomerUC;

    @GetMapping("{email} {password}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "email") final String email, @PathVariable(value = "password") final String password) {
        final Optional<Customer> customerOptional = Optional.ofNullable(getCustomerUC.getCustomer(email, password));
        if (customerOptional.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customerOptional.get());
    }
}
