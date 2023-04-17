package com.example.lab3_20200643.controllers;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Paciente;
import com.example.lab3_20200643.repository.DoctorRepository;
import com.example.lab3_20200643.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/doctores")
public class DoctorController {
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;
    public DoctorController(DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }
    //############################################################3
    @GetMapping("/listar")
    public String listar(Model model){
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("listaDoctores", lista);
        return "doctores/listaDoc";
    }
    @GetMapping("listaPacientes")
    public String lista(Model model, @RequestParam("id") int id){
        List<Paciente> listaPacixDoc = pacienteRepository.findPacienteByDoctor_Id(id);
        model.addAttribute("lista",listaPacixDoc);
        return "doctores/listaPacientes";
    }





}
