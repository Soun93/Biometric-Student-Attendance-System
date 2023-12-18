package com.example.backend2.controllers;

import org.springframework.stereotype.Controller;
import com.example.backend2.entities.*;
import com.example.backend2.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.List;


@Controller
public class ClaseController {
    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private PasswordRepository userRepository;
    @Autowired
    private AsistenciaRepository asistenciaRepository;

//Mandar las clases del Profesor
    @GetMapping("/home/{idProfesor}")
    public String listarClases(@PathVariable Long idProfesor, Model model) {
        Profesores profesor = profesorRepository.findById(idProfesor)
                .orElseThrow(() -> new IllegalArgumentException("Profesor inválido: " + idProfesor));

        List<Clases> clases = claseRepository.findByProfesor(profesor);    
        model.addAttribute("nombreProfesor", profesor.getNombreProfesor());
        model.addAttribute("clases", clases);
        return "home";
    }

}
