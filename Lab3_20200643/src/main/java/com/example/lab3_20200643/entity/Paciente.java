package com.example.lab3_20200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Getter
@Setter
@Controller
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "fecha_cita")
    private Date fecha_cita;

    @Column(name = "numero_habitacion")
    private int numero_habitacion;

    @Column(name = "doctor_id")
    private int doctor_id;

    @Column(name = "hospital_id")
    private int hospital_id;
}
