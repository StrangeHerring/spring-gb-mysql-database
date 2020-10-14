package com.example.springgbmysqldatabase.repository;

import com.example.springgbmysqldatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeBetween(int minAge, int maxAge);
}
