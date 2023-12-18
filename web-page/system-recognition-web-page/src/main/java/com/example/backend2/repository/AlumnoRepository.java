package com.example.backend2.repository;

import com.example.backend2.entities.Alumno;
import com.example.backend2.entities.Asistencia;
import com.example.backend2.entities.Clases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
