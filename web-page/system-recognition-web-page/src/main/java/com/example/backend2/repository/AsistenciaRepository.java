package com.example.backend2.repository;

import com.example.backend2.entities.Alumno;
import com.example.backend2.entities.Asistencia;
import com.example.backend2.entities.Clases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    List<Asistencia> findByClase(Clases clase);
}
