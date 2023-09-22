package com.example.musicalist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.musicalist.modelo.UsuarioVotanteRepository;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;

    
}
