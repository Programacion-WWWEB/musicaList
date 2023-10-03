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

import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.TrackService;


@RestController
@RequestMapping("/Track")
public class TrackController  {
    @Autowired
    private TrackService trackService;
    
    @GetMapping
    public List<Track> lista(){
        return trackService.listar();
    }

    @PostMapping
    public Track insertar(@RequestBody Track track){
        return trackService.insertar(track);
    }

    @PutMapping
    public Track actualizar(@RequestBody Track track){
        return trackService.actualizar(track);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Track track){
        trackService.eliminar(track);
    }
}
