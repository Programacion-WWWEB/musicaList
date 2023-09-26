package com.example.musicalist.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class UsuarioVotante{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String contrasena;

    @Getter @Setter 
    private String correo;
    
    @Getter @Setter
    private String nombrePerfil;

    @OneToMany(mappedBy = "usuarioVotante")
    private Set<Voto> votos = new HashSet<>();

    
}
