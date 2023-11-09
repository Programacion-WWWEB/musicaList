package com.example.musicalist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.GeneroDTO;
import com.example.musicalist.modelo.Genero;
import com.example.musicalist.services.GeneroService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/Genero")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    
    @GetMapping("/Lista")
    public List<GeneroDTO> lista(){
        return generoService.listar();
    }

    @GetMapping("/Buscar/{id}")
    public GeneroDTO buscar(@PathVariable("id")Long id){
        return generoService.buscar(id);
    }

    @PostMapping("/Agregar")
    public Genero insertar(@RequestBody Genero genero){
        return generoService.insertar(genero);
    }

    @PutMapping("/Actualizar")
    public Genero actualizar(@RequestBody Genero usuario){
        return generoService.actualizar(usuario);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody Genero usuario){
        generoService.eliminar(usuario);
    }

    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id){
        generoService.eliminar(id);
    }
}
