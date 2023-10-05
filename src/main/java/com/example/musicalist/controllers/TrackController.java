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

import com.example.musicalist.DTOs.TrackDTO;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.services.TrackService;


@RestController
@RequestMapping("/Track")
public class TrackController {
    @Autowired
    private TrackService TrackService;
    
    @GetMapping("/Lista")
    public List<TrackDTO> lista(){
        return TrackService.listar();
    }

    @GetMapping("/Lista/{id}")
    public List<TrackDTO> lista(@PathVariable("id")Long id){
        return TrackService.listar(id);
    }

    @GetMapping("/Buscar/{id}")
    public TrackDTO buscar(@PathVariable("id")Long id){
        return TrackService.buscar(id);
    }

    @PostMapping("/Agregar")
    public Track insertar(@RequestBody Track Track){
        return TrackService.insertar(Track);
    }

    @PutMapping("/Actualizar")
    public Track actualizar(@RequestBody Track Track){
        return TrackService.actualizar(Track);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody Track Track){
        TrackService.eliminar(Track);
    }

    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id){
        TrackService.eliminar(id);
    }
}
