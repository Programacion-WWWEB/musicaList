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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.AlbumDTO;
import com.example.musicalist.modelo.Album;
import com.example.musicalist.services.AlbumService;

@RestController
@RequestMapping("/Album")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AlbumController {

    @Autowired
    private AlbumService AlbumService;
    

    @GetMapping("/Lista")
    public List<AlbumDTO> lista(@RequestHeader("Authorization") String token){
        String cleanToken = token.replace("Bearer ", "");
        System.out.println("Token recibido" + cleanToken);
        return AlbumService.listar();
    }

    @GetMapping("/Buscar/{id}")
    public AlbumDTO buscar(@PathVariable("id")Long id){
        return AlbumService.buscar(id);
    }

    @PostMapping("/Agregar")
    public Album insertar(@RequestBody Album album, @RequestHeader("Authorization") String token){
        String cleanToken = token.replace("Bearer ", "");
        System.out.println("Token recibido" + cleanToken);
        return AlbumService.insertar(album);
    }

    @PutMapping("/Actualizar")
    public Album actualizar(@RequestBody Album album){
        return AlbumService.actualizar(album);
    }

    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody Album album){
        AlbumService.eliminar(album);
    }

    @DeleteMapping("/Borrar/{id}")
    public void eliminar(@PathVariable("id")Long id){
        AlbumService.eliminar(id);
    }
}
