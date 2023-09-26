package com.example.musicalist.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@IdClass(VotoId.class)
public class Voto {

    @Id
    private Long id;

    @Id
    private Long track_id;
    

    @ManyToOne()
    @JoinColumn(name = "id" , insertable = false, updatable = false)
    UsuarioVotante usuarioVotante;

    
    @ManyToOne()
    @JoinColumn(name = "track_id", insertable = false, updatable = false)
    Track track;

    public Voto(){};

    public Voto(Long trackId, Long userId, Track track, UsuarioVotante usuarioVotante) {
        this.track_id = trackId;
        this.id = userId;
        this.track = track;
        this.usuarioVotante = usuarioVotante;
        
    }
    
    
}
