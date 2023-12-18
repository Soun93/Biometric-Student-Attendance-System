package com.example.backend2.entities;
import jakarta.persistence.*;
@Entity
@Table(name="Profesores")
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "nombre_profesor",unique = true)
    private String nombreProfesor;

    @Column(name = "correo")
    private String correo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id", referencedColumnName = "id")
    private Password password;

    // constructores
    public Profesores() {
    }

    public Profesores(Long idProfesor, String nombreProfesor, String correo) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.correo = correo;
    }

    public Profesores(Password password) {
        this.password = password;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Profesores(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    //getters
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }
//setters
    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
