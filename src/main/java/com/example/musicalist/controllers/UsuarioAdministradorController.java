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

import com.example.musicalist.modelo.UsuarioAdministrador;
import com.example.musicalist.modelo.UsuarioAdministradorService;

@RestController
@RequestMapping("/UsuarioAdministrador")
public class UsuarioAdministradorController {
    @Autowired
    private UsuarioAdministradorService usuarioAdministradorService;
    
    @GetMapping
    public List<UsuarioAdministrador> lista(){
        return usuarioAdministradorService.listar();
    }

    @PostMapping
    public UsuarioAdministrador insertar(@RequestBody UsuarioAdministrador usuario){
        return usuarioAdministradorService.insertar(usuario);
    }

    @PutMapping
    public UsuarioAdministrador actualizar(@RequestBody UsuarioAdministrador usuario){
        return usuarioAdministradorService.actualizar(usuario);
    }

    @DeleteMapping
    public void eliminar(@RequestBody UsuarioAdministrador usuario){
        usuarioAdministradorService.eliminar(usuario);
    }
}
