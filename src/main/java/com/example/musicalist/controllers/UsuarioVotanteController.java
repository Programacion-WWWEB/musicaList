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

import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.services.UsuarioVotanteService;

@RestController
@RequestMapping("/UsuarioVotante")

public class UsuarioVotanteController {
    @Autowired
    private UsuarioVotanteService UsuarioVotanteService;
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/Lista")
    public List<UsuarioVotanteDTO> lista(){
        return UsuarioVotanteService.listar();
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/Buscar/{id}")
    public UsuarioVotanteDTO buscar(@PathVariable("id")Long id){
        return UsuarioVotanteService.buscar(id);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PostMapping("/Agregar")
    public UsuarioVotante insertar(@RequestBody UsuarioVotante UsuarioVotante){
        return UsuarioVotanteService.insertar(UsuarioVotante);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PutMapping("/Actualizar")
    public UsuarioVotante actualizar(@RequestBody UsuarioVotante UsuarioVotante){
        return UsuarioVotanteService.actualizar(UsuarioVotante);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody UsuarioVotante UsuarioVotante){
        UsuarioVotanteService.eliminar(UsuarioVotante);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id){
        UsuarioVotanteService.eliminar(id);
    }
}

