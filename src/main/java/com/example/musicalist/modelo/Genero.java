package com.example.musicalist.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(exclude = {"idgenero"})
public class Genero {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idgenero;
    
    @Getter
    @Setter
    private String nombre;


    @OneToMany(mappedBy = "genero")
    private Set<Recomendacion> recomendar = new HashSet<>();


}
