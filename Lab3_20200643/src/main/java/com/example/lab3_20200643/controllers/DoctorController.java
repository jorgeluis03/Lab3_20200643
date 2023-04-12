package com.example.lab3_20200643.controllers;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Hospital;
import com.example.lab3_20200643.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctores")
public class DoctorController {
    final DoctorRepository doctorRepository;


    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    //############################################################3
    @GetMapping("/listar")
    public String listar(Model model){
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("listaDoctores", lista);
        return "doctores/lista";
    }





}
