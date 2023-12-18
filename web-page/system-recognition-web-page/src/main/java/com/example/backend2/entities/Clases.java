package com.example.backend2.entities;
import com.example.backend2.entities.Profesores;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Clases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long idClase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesores profesor;

    @Column(name = "nombre_clase")
    private String nombreClase;

    @Column(name = "año")
    private Integer año;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "aula")
    private String aula;

    @Column(name = "dias")
    private String dias;

    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;

    @Column(name = "hora_salida")
    private LocalTime horaSalida;

    public Clases() {
    }

    public Clases(Long idClase, Profesores profesor, String nombreClase, Integer año, String grupo, String aula, String dias) {
        this.idClase = idClase;
        this.profesor = profesor;
        this.nombreClase = nombreClase;
        this.año = año;
        this.grupo = grupo;
        this.aula = aula;
        this.dias = dias;
    }

    public Clases(Profesores profesor, String nombreClase, Integer año, String grupo, String aula, String dias) {
        this.profesor = profesor;
        this.nombreClase = nombreClase;
        this.año = año;
        this.grupo = grupo;
        this.aula = aula;
        this.dias = dias;
    }

    public Clases(String nombreClase, Integer año, String grupo) {
        this.nombreClase = nombreClase;
        this.año = año;
        this.grupo = grupo;
    }

    public Clases(Long idClase, Profesores profesor, String nombreClase, Integer año, String grupo, String aula, String dias, LocalTime horaEntrada, LocalTime horaSalida) {
        this.idClase = idClase;
        this.profesor = profesor;
        this.nombreClase = nombreClase;
        this.año = año;
        this.grupo = grupo;
        this.aula = aula;
        this.dias = dias;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Clases(LocalTime horaEntrada, LocalTime horaSalida) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Long getIdClase() {
        return idClase;
    }

    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
}
