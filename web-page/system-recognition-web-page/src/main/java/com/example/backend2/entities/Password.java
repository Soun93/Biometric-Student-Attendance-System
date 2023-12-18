package com.example.backend2.entities;
import com.example.backend2.entities.*;
import jakarta.persistence.*;

import java.util.List;


@Entity
    @Table(name = "passwords")
    public class Password {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String username;

        private String password;

        @OneToOne
        @JoinColumn(name = "profesor_id", referencedColumnName = "id_profesor")
        private Profesores profesor;


    public Password() {
    }

    public Password(Long id, String username, String password, Profesores profesor, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profesor = profesor;
    }

    public Password(String username, String password, Profesores profesor, List<String> roles) {
        this.username = username;
        this.password = password;
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

}


