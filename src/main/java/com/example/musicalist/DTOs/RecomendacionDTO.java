package com.example.musicalist.DTOs;

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Genero;

import lombok.Getter;
import lombok.Setter;

public class RecomendacionDTO {

    @Getter @Setter
    private Long album_id;
    
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Genero genero;
    
    @Getter @Setter
    private Album album = new Album();

    public RecomendacionDTO(){

        Genero genero = new Genero();
        Album album = new Album();
    }

    public RecomendacionDTO(Genero genero, Album album){

        this.genero = genero;
        this.album = album;
    }



    
}
