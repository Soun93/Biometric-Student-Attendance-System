package com.example.backend2.repository;
import com.example.backend2.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PasswordRepository extends JpaRepository<Password, Long> {

    Password findByUsername(String username);
}

