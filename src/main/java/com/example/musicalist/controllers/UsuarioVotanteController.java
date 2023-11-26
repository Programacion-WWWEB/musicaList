package com.example.musicalist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.respositories.UsuarioVotanteRepository;
import com.example.musicalist.services.UsuarioVotanteService;

@RestController
@RequestMapping("/UsuarioVotante")

public class UsuarioVotanteController {
    @Autowired
    private UsuarioVotanteService UsuarioVotanteService;

    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/Lista")
    public List<UsuarioVotanteDTO> lista(@RequestHeader("Authorization") String token){
        return UsuarioVotanteService.listar();
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/Buscar/{id}")
    public UsuarioVotanteDTO buscar(@PathVariable("id")Long id, @RequestHeader("Authorization") String token){
        return UsuarioVotanteService.buscar(id);
    }
    @CrossOrigin(origins = {"http://localhost:4200/registrar-usuario", "http://localhost:4200/home", "http://localhost:4200"}, allowedHeaders = "*")
    @PostMapping("/Agregar")
    public ResponseEntity<?> insertar(@RequestBody UsuarioVotanteDTO usuarioVotante){
        Optional<UsuarioVotante> existingUser = usuarioVotanteRepository
        .findUserByNombrePerfilAndContrasena(usuarioVotante.getNombrePerfil(), usuarioVotante.getContrasena());

        if (existingUser.isPresent()) {
        // User with the same credentials already exists, return an error response
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("User with the same credentials already exists");
    }
    UsuarioVotante usuarioAInsertar = new UsuarioVotante();
    usuarioAInsertar.setId(usuarioVotante.getId());
    usuarioAInsertar.setNombre(usuarioVotante.getNombre());
    usuarioAInsertar.setNombrePerfil(usuarioVotante.getNombrePerfil());
    usuarioAInsertar.setCorreo(usuarioVotante.getCorreo());
    usuarioAInsertar.setContrasena(usuarioVotante.getContrasena());
    UsuarioVotanteService.insertar(usuarioAInsertar);

    UsuarioVotanteDTO usuarioVotanteDTO = new UsuarioVotanteDTO();

    usuarioVotanteDTO.setCorreo(usuarioVotante.getCorreo());
    usuarioVotanteDTO.setNombre(usuarioVotante.getNombre());
    usuarioVotanteDTO.setContrasena(usuarioVotante.getContrasena());
    usuarioVotanteDTO.setId(usuarioVotanteDTO.getId());
    usuarioVotanteDTO.setNombrePerfil(usuarioVotante.getNombrePerfil());

    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioVotanteDTO);
}


    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PutMapping("/Actualizar")
    public UsuarioVotante actualizar(@RequestBody UsuarioVotante UsuarioVotante, @RequestHeader("Authorization") String token){
        return UsuarioVotanteService.actualizar(UsuarioVotante);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody UsuarioVotante UsuarioVotante, @RequestHeader("Authorization") String token){
        UsuarioVotanteService.eliminar(UsuarioVotante);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id, @RequestHeader("Authorization") String token){
        UsuarioVotanteService.eliminar(id);
    }
}

