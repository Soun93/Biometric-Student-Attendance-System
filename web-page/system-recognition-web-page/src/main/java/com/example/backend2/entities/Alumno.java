package com.example.backend2.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Column(name = "nombre_alumno")
    private String nombreAlumno;

    @Column(name = "año")
    private Integer año;

    @Column(name = "carrera")
    private String carrera;


    // constructores, getters y setters

    public Alumno() {
    }

    public Alumno(Long idAlumno, String nombreAlumno, Integer año, String carrera) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.año = año;
        this.carrera = carrera;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}