package com.example.lab3_20200643.controllers;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Paciente;
import com.example.lab3_20200643.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("pacientes")
public class PacienteController {
    //##################33
    final PacienteRepository pacienteRepository;


    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    //###########
    @GetMapping("/listar")
    public String listar (Model model){
        List<Paciente> lista = pacienteRepository.findAll();
        model.addAttribute("listaPacientes", lista);
        return "pacientes/lista";
    }


}
