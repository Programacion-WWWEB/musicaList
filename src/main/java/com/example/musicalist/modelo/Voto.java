package com.example.musicalist.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


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
    @Getter @Setter
    UsuarioVotante usuarioVotante;

    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "track_id", insertable = false, updatable = false)
    @Getter @Setter
    Track track;

    public Voto(){};

    public Voto(Track track, UsuarioVotante usuarioVotante) {
        this.track_id = track.getTrack_id();
        this.id = usuarioVotante.getId();
        this.track = track;
        this.usuarioVotante = usuarioVotante;
        
    }
    
    
}
