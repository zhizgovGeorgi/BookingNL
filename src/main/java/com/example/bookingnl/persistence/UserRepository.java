package com.example.bookingnl.persistence;

import com.example.bookingnl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
    User save(User user);
    void deleteByEmail(String email);
    List<User> findAll ();
}
