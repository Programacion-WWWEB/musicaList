package com.example.musicalist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.UsuarioAdministradorDTO;
import com.example.musicalist.modelo.UsuarioAdministrador;
import com.example.musicalist.services.UsuarioAdministradorService;

@RestController
@RequestMapping("/UsuarioAdministrador")
public class UsuarioAdministradorController {
    @Autowired
    private UsuarioAdministradorService UsuarioAdministradorService;
    
    @GetMapping("/Lista")
    public List<UsuarioAdministradorDTO> lista(){
        return UsuarioAdministradorService.listar();
    }

    @GetMapping("/Buscar/{id}")
    public UsuarioAdministradorDTO buscar(@PathVariable("id")Long id){
        return UsuarioAdministradorService.buscar(id);
    }

    @PostMapping("/Agregar")
    public UsuarioAdministrador insertar(@RequestBody UsuarioAdministrador UsuarioAdministrador){
        return UsuarioAdministradorService.insertar(UsuarioAdministrador);
    }

    @PutMapping("/Actualizar")
    public UsuarioAdministrador actualizar(@RequestBody UsuarioAdministrador UsuarioAdministrador){
        return UsuarioAdministradorService.actualizar(UsuarioAdministrador);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody UsuarioAdministrador UsuarioAdministrador){
        UsuarioAdministradorService.eliminar(UsuarioAdministrador);
    }

    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id){
        UsuarioAdministradorService.eliminar(id);
    }
}
