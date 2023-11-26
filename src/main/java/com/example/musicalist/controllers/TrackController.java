package com.example.musicalist.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.musicalist.DTOs.TrackDTO;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.services.TrackService;


@RestController
@RequestMapping("/Track")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TrackController {
    @Autowired
    private TrackService trackService;
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/Lista")
    public List<TrackDTO> lista(@RequestHeader("Authorization") String token){
        return trackService.listar();
    }

    @GetMapping("/Lista/{id}")
    public List<TrackDTO> lista(@PathVariable("id")Long id, @RequestHeader("Authorization") String token){
        return trackService.listar(id);

    }

    @GetMapping("/Buscar/{id}")
    public TrackDTO buscar(@PathVariable("id")Long id, @RequestHeader("Authorization") String token){
        return trackService.buscar(id);
    }

    @PostMapping("/Agregar")
    public Track insertar(@RequestBody TrackDTO trackDTO, @RequestHeader("Authorization") String token){
        Track insertedTrack = trackService.insertar(trackDTO);

        return modelMapper.map(insertedTrack, Track.class);
    }

   

    @PutMapping("/Actualizar")
    public Track actualizar(@RequestBody Track Track){

        return trackService.actualizar(Track);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody Track Track){

        trackService.eliminar(Track);

    }

    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id){

        trackService.eliminar(id);

    }
}
