package com.example.musicalist.DTOs;

import lombok.Getter;
import lombok.Setter;

public class UsuarioVotanteDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter 
    private String correo;

    @Getter @Setter 
    private String contrasena;
    
    @Getter @Setter
    private String nombrePerfil;
}
