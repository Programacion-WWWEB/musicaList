package com.example.musicalist.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(RecomendacionId.class)
public class Recomendacion {
    
    @Id
    private Long album_id;
    @Id
    private Long id;
    
    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Genero genero;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    Album album;

    public Recomendacion(){};

    public Recomendacion(Album album, Genero genero) {
        this.album_id = album.getAlbum_id();
        this.id = genero.getId();
        this.album = album;
        this.genero = genero;
    }
}
