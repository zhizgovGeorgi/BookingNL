package com.example.bookingnl.bussines.impl;

import com.example.bookingnl.bussines.UserService;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @Override
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll (){
       return repository.findAll();
    }
}
