package com.example.musicalist.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@IdClass(VotoId.class)
public class Voto {

    @Id
    private Long id;

    @Id
    private Long track_id;
    

    @ManyToOne()
    @JoinColumn(name = "id" , insertable = false, updatable = false)
    @JsonIgnore
    UsuarioVotante usuarioVotante;

    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "track_id", insertable = false, updatable = false)
    Track track;

    public Voto(){};

    public Voto(Track track, UsuarioVotante usuarioVotante) {
        this.track_id = track.getTrack_id();
        this.id = usuarioVotante.getId();
        this.track = track;
        this.usuarioVotante = usuarioVotante;
        
    }
    
    
}
