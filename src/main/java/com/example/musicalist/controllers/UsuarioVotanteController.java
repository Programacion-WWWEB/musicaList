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

import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.modelo.UsuarioVotanteService;

@RestController
@RequestMapping("/UsuarioVotante")
public class UsuarioVotanteController {
    @Autowired
    private UsuarioVotanteService usuarioVotanteService;
    
    @GetMapping
    public List<UsuarioVotante> lista(){
        return usuarioVotanteService.listar();
    }

    @PostMapping
    public UsuarioVotante insertar(@RequestBody UsuarioVotante usuario){
        return usuarioVotanteService.insertar(usuario);
    }

    @PutMapping
    public UsuarioVotante actualizar(@RequestBody UsuarioVotante usuario){
        return usuarioVotanteService.actualizar(usuario);
    }

    @DeleteMapping
    public void eliminar(@RequestBody UsuarioVotante usuario){
        usuarioVotanteService.eliminar(usuario);
    }
}
