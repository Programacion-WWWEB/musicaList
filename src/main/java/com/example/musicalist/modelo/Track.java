package com.example.musicalist.modelo;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(exclude = {"IdUsuario","genero"})
public class Cancion {
     

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Long IdUsuario;
     
    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private float valoracion;

    @Getter @Setter
    private int rating;
    
    @Getter @Setter 
    private Time duracion;
    
    @ManyToOne()
    @JoinColumn(name = "idgenero")
    Genero genero;

}
