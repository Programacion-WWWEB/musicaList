package com.example.musicalist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.RecomendacionDTO;
import com.example.musicalist.modelo.Recomendacion;
import com.example.musicalist.services.RecomendacionService;

@RestController
@RequestMapping("/Recomendacion")
public class RecomendacionController {

    @Autowired
    RecomendacionService recomendacionService;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PostMapping("/Agregar")
    public Recomendacion insertar(@RequestBody RecomendacionDTO recomendacionDTO, @RequestHeader("Authorization") String token){

        return recomendacionService.insertar(recomendacionDTO);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/Lista")
    public List<RecomendacionDTO> listar(@RequestHeader("Authorization") String token){

        return recomendacionService.listar();
    }
    
    
    
}
