package com.example.backend2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend2.entities.Password;
import com.example.backend2.entities.Profesores;

public interface ProfesorRepository extends JpaRepository<Profesores, Long> {
    Profesores findByPassword(Password password);
}
