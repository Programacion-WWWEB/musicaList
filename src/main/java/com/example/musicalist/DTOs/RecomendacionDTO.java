package com.example.musicalist.DTOs;

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Genero;

import lombok.Getter;
import lombok.Setter;

public class RecomendacionDTO {

    @Getter @Setter
    private Long album_id;
    
    @Getter @Setter
    private Long genero_id;

    @Getter @Setter
    private Genero genero;
    
    @Getter @Setter
    private Album album;



    
}
