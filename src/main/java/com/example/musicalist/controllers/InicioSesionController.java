package com.example.musicalist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.modelo.UsuarioVotanteRepository;

@Controller
@RequestMapping("/iniciarSesion")
public class InicioSesionController {

    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;

    @GetMapping
    public String obtenerFormularioInicioSesion(@ModelAttribute("usuarioVotante") UsuarioVotante usuarioVotante, Model model){
        

        model.addAttribute("usuarioVotante", new UsuarioVotante());
        return "iniciarSesion";
    }

    @PostMapping
    public String iniciarSesion(@ModelAttribute UsuarioVotante usuarioVotante, Model model){


        String nombrePerfil = usuarioVotante.getNombrePerfil();
        String contrasena = usuarioVotante.getContrasena();

        UsuarioVotante foundUser = usuarioVotanteRepository.findUserByNombrePerfil(nombrePerfil).orElse(null);

        if (foundUser != null && foundUser.getContrasena().equals(contrasena)) {
            
            return "generos";
        } else {
            
            model.addAttribute("error", "Usuario o contraseña incorrectos.");
            return "iniciarSesion"; 
        }
    }
    }



    
    
