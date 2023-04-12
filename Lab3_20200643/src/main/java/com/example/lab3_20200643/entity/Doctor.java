package com.example.lab3_20200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
@Getter
@Setter
@Controller
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "hospital_id")
    private int hospital_id;


}
