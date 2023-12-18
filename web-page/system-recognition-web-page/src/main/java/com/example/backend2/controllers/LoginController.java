package com.example.backend2.controllers;

import com.example.backend2.entities.Password;
import com.example.backend2.entities.Profesores;
import com.example.backend2.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private PasswordRepository usuarioRepository;
    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Password());
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute Password usuario, HttpSession session,Model model) {
        Password user = usuarioRepository.findByUsername(usuario.getUsername());
        if (user != null && user.getPassword().equals(usuario.getPassword())) {
            Profesores profesor = profesorRepository.findByPassword(user);
            Long profesorId = profesor.getIdProfesor();
            model.addAttribute("idprofesor", profesorId);
            session.setAttribute("user", user);
            String urlId = "redirect:/home/" + profesorId;
            return urlId;
        } else {
            return "login";
        }
    }



}