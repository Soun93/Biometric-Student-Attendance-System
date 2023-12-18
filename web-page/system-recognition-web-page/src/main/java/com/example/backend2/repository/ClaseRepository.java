package com.example.backend2.repository;

import com.example.backend2.entities.Clases;
import com.example.backend2.entities.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clases, Long> {
    List<Clases> findByProfesor(Profesores profesor);
    

}