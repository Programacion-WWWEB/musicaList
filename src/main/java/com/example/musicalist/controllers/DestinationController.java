package com.example.musicalist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DestinationController {

    @GetMapping("templates/registro")
    public String registro(){

        return "registro";
    }

    @GetMapping("templates/contacto")
    public String contacto(){

        return "contacto";
    }

    @GetMapping("templates/main")
    public String main(){

        return "main";
    }

    @GetMapping("templates/generos")
    public String generos(){

        return "generos";
    }

    @GetMapping("templates/iniciarSesion")
    public String iniciarSesion(){

        return "iniciarSesion";
    }

    @GetMapping("templates/canciones_genero")
    public String cancionesGenero(){

        return "canciones_genero";
    }
    

    @GetMapping("templates/cancion")
    public String cancion(){

        return "cancion";
    }
    
    @GetMapping("/cancion")
    public String cancionTemplate(){

        return "cancion";
    }

    @GetMapping("/registro")
    public String registroTemplate(){

        return "registro";
    }

    @GetMapping("/iniciarSesion")
    public String iniciarSesionTemplate(){

        return "iniciarSesion";
    }

    @GetMapping("/main")
    public String mainTemplate(){

        return "main";
    }

    @GetMapping("/generos")
    public String generosTemplate(){

        return "generos";
    }
    
}
