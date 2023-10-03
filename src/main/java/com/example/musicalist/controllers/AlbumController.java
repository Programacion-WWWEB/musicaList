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

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.AlbumService;

@RestController
@RequestMapping("/Album")
public class AlbumController {
    @Autowired
    private AlbumService AlbumService;
    
    @GetMapping
    public List<Album> lista(){
        return AlbumService.listar();
    }

    @PostMapping
    public Album insertar(@RequestBody Album album){
        
        return AlbumService.insertar(album);
    }

    @PutMapping
    public Album actualizar(@RequestBody Album album){
        return AlbumService.actualizar(album);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Album album){
        AlbumService.eliminar(album);
    }
}
