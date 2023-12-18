package com.example.backend2.controllers;
import org.springframework.stereotype.Controller;
import com.example.backend2.entities.*;
import com.example.backend2.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.*;

 @RestController
 public class AsistenciaController {
     @Autowired
     private AsistenciaRepository asistenciaRepository;
     @Autowired
     private ClaseRepository claseRepository;
/**
     @GetMapping("/home/{idClase}/asistencias")
     public List<Asistencia> getAsistencias(@PathVariable Long idClase) {
         Clases clase = claseRepository.findById(idClase).orElseThrow(() -> new RuntimeException("Clase no encontrada con id: " + idClase));
         List<Asistencia> asistencias = asistenciaRepository.findByClase(clase);
         List<String> nombres = new ArrayList<>();
         for (Asistencia asistencia : asistencias) {
             List<Alumno> alumnos = (List<Alumno>) asistencia.getAlumno();
             for (Alumno alumno : alumnos) {
                 String nombreAlumno = alumno.getNombreAlumno();

             }
         }


         return asistencias ;

         }
**/
@GetMapping("/home/{idClase}/asistencias")
public List<AsistenciaDTO> getAsistencias(@PathVariable Long idClase) {
    Clases clase = claseRepository.findById(idClase)
            .orElseThrow(() -> new RuntimeException("Clase no encontrada con id: " + idClase));
    List<Asistencia> asistencias = asistenciaRepository.findByClase(clase);

    List<AsistenciaDTO> asistenciasDTO = new ArrayList<>();
    for (Asistencia asistencia : asistencias) {
        Alumno alumno = asistencia.getAlumno();
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno);
        List<String> nombresAlumnos = new ArrayList<>();
        for (Alumno alumno2 : alumnos) {
            nombresAlumnos.add(alumno2.getNombreAlumno());
        }
        AsistenciaDTO asistenciaDTO = new AsistenciaDTO();
        asistenciaDTO.setId(asistencia.getIdAsistencia());
        asistenciaDTO.setFecha(asistencia.getFecha());
        asistenciaDTO.setHoraEntrada(asistencia.getHoraEntrada());
        asistenciaDTO.setHoraSalida(asistencia.getHoraSalida());
        asistenciaDTO.setEstadoAsistencia(asistencia.isEstadoAsistencia());
        asistenciaDTO.setNombresAlumnos(nombresAlumnos);
        asistenciasDTO.add(asistenciaDTO);
    }

    return asistenciasDTO;
}

 }


