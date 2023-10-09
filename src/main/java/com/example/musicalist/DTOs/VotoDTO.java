package com.example.musicalist.DTOs;

import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.UsuarioVotante;

import lombok.Getter;
import lombok.Setter;

public class VotoDTO {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long track_id;
    
    @Getter @Setter
    private UsuarioVotante usuarioVotante = new UsuarioVotante();
    
    @Getter @Setter
    private Track track;

    public VotoDTO() {
        usuarioVotante = new UsuarioVotante(); 
        track = new Track();
    }

    public VotoDTO(UsuarioVotante usuarioVotante, Track track){

        this.usuarioVotante = usuarioVotante;
        this.track = track;
    }
    
    
}
