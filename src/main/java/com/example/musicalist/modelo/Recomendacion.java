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
    private Long genero_id;
    
    
    @ManyToOne()
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    Genero genero;

    @ManyToOne()
    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    Album album;

    public Recomendacion(){};

    public Recomendacion(Album album, Genero genero) {
        this.album_id = album.getAlbum_id();
        this.genero_id = genero.getId();
        this.album = album;
        this.genero = genero;
    }
}
