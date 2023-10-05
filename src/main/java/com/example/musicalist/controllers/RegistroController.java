package com.example.musicalist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.respositories.UsuarioVotanteRepository;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;

    @GetMapping
    public String showRegisterForm(@ModelAttribute("usuarioVotante") UsuarioVotante usuarioVotante, Model model){

        model.addAttribute("usuarioVotante", new UsuarioVotante());
        return "registro";
    }

    @PostMapping
    public String guardarRegistro(@ModelAttribute UsuarioVotante usuarioVotante){

        usuarioVotanteRepository.save(usuarioVotante);

        return "registro";
    }

    
}
