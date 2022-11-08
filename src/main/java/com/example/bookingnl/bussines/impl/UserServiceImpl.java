package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.UserService;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.persistence.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if (user.isEmpty()) {
            log.error("User not found");
            throw new UsernameNotFoundException("Username not found in db");
        } else {
            log.info("User with email {} found", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.get().getRole()));
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), authorities);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @Override
    public void deleteByEmail(String email) {
      /*  User user = repository.findByEmail(email);
        if (user != null) {
            log.error("User not found");
        } else {
            repository.deleteByEmail(email);
            log.info("User with email {} found", email);
        }*/
    }

    @Override
    public User save(User newUser) {

        if (repository.existsByEmail(newUser.getEmail()) == true) {
            log.error("User not found");
            return null;
            //Email taken
            // TODO
        } else {
            log.info("Saving new user {} .", newUser.getFirstName());
            newUser.setPassword(encoder.encode(newUser.getPassword()));
            return repository.save(newUser);
        }
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }


}
