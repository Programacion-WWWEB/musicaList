package com.example.musicalist.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(RecomendacionId.class)
public class Recomendacion {
    
    @Id
    private Long albumId;
    @Id
    private Long idgenero;
    
    
    @ManyToOne()
    @JoinColumn(name = "idgenero", insertable = false, updatable = false)
    Genero genero;

    @ManyToOne()
    @JoinColumn(name = "albumId", insertable = false, updatable = false)
    Album album;
}
