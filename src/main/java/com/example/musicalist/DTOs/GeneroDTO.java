package com.example.musicalist.DTOs;


import java.util.HashSet;
import java.util.Set;

import com.example.musicalist.modelo.Recomendacion;

import lombok.Getter;
import lombok.Setter;

public class GeneroDTO {

    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String nombre;
    
    @Getter @Setter
     private Set<Recomendacion> recomendar = new HashSet<>();
    
}
