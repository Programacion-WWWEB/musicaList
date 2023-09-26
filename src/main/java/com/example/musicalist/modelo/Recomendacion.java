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
    private Long album_id;
    @Id
    private Long id;
    
    
    @ManyToOne()
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Genero genero;

    @ManyToOne()
    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    Album album;

    public Recomendacion(){};

    public Recomendacion(Long albumId, Long idgenero, Album album, Genero genero) {
        this.album_id = albumId;
        this.id = idgenero;
        this.album = album;
        this.genero = genero;
    }
}
