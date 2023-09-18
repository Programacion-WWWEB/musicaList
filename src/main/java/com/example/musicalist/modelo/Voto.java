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
    private Long trackId;
    
    @ManyToOne()
    @JoinColumn(name = "id" , insertable = false, updatable = false)
    UsuarioVotante usuarioVotante;

    
    @ManyToOne()
    @JoinColumn(name = "trackId", insertable = false, updatable = false)
    Track track;
    
    
}
