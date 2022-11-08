package com.example.bookingnl;

import com.example.bookingnl.bussines.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookingNlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingNlApplication.class, args);
    }

   // CommandLineRunner run(UserService userService){}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
