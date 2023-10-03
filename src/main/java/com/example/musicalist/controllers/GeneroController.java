package com.example.musicalist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.modelo.Genero;
import com.example.musicalist.modelo.GeneroService;

@RestController
@RequestMapping("/Genero")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    
    @GetMapping
    public List<Genero> lista(){
        return generoService.listar();
    }

    @PostMapping
    public Genero insertar(@RequestBody Genero genero){
        return generoService.insertar(genero);
    }

    @PutMapping
    public Genero actualizar(@RequestBody Genero usuario){
        return generoService.actualizar(usuario);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Genero usuario){
        generoService.eliminar(usuario);
    }
}
