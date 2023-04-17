package com.example.lab3_20200643.controllers;

import com.example.lab3_20200643.entity.Doctor;
import com.example.lab3_20200643.entity.Paciente;
import com.example.lab3_20200643.repository.DoctorRepository;
import com.example.lab3_20200643.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("pacientes")
public class PacienteController {
    //##################33
    final PacienteRepository pacienteRepository;
    final DoctorRepository doctorRepository;

    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }
    //###########
    @GetMapping("/listar")
    public String listar (Model model){
        List<Paciente> lista = pacienteRepository.findAll();
        model.addAttribute("listaPacientes", lista);
        return "pacientes/lista";
    }
    @GetMapping("/editar")
    public String editar (Model model, @RequestParam("id") int id){
        //vemos si existe el id del objeto mediante un objeto opcional
        Optional<Paciente> optPaciente =pacienteRepository.findById(id);
        //si lo encuentra, lo recupera por get() y lo envia a la vista
        if(optPaciente.isPresent()){
            Paciente paciente = optPaciente.get();
            model.addAttribute("paciente", paciente);

            return "pacientes/edit";
        }else {
            return "redirect:/pacientes/listar";
        }

    }
    @PostMapping("/guardar")
    public String guardar (@RequestParam("numero_habitacion") int num,@RequestParam("id") int id){
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if(optionalPaciente.isPresent()){
            pacienteRepository.actualizarPaciente(num,id);
            return "redirect:/pacientes/listar";
        }else {
            return "redirect:/pacientes/listar";
        }

    }
    @GetMapping("/derivar")
    public String derivar(Model model, @RequestParam("id") int id){
        //encontramos el id
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if(optionalPaciente.isPresent()){
            Paciente paciente = optionalPaciente.get();
            List<Doctor> listaDoctores = doctorRepository.findAll();
            model.addAttribute("paciente",paciente);
            model.addAttribute("listaDoc", listaDoctores);
            return "pacientes/derivar";

        }else {
            return "redirect:/pacientes/listar";
        }

    }
    @PostMapping("/guardarDerivacion")
    public String guardarDerivacion(@RequestParam("id") int id, @RequestParam("idDocNuevo") int idDoc ){
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if(optionalPaciente.isPresent()){
            pacienteRepository.actualizarDoctorPaciente(idDoc,id);
            return "redirect:/pacientes/listar";
        }else {
            return "redirect:/pacientes/listar";
        }
    }


}
