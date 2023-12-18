package com.example.backend2.entities;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class AsistenciaDTO {
    private Long id;
    private LocalDate fecha;
    private List<String> nombresAlumnos;
    private LocalTime horaEntrada;

    private LocalTime horaSalida;

    private boolean estadoAsistencia;
    public AsistenciaDTO() {
    }

    public AsistenciaDTO(Long id, LocalDate fecha, List<String> nombresAlumnos, LocalTime horaEntrada, LocalTime horaSalida, boolean estadoAsistencia) {
        this.id = id;
        this.fecha = fecha;
        this.nombresAlumnos = nombresAlumnos;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.estadoAsistencia = estadoAsistencia;
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


    public boolean isEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(boolean estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha =  fecha;
    }

    public List<String> getNombresAlumnos() {
        return nombresAlumnos;
    }

    public void setNombresAlumnos(List<String> nombresAlumnos) {
        this.nombresAlumnos = nombresAlumnos;
    }
}
