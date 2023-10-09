package com.example.musicalist.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.VotoDTO;
import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.modelo.Voto;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.TrackRepository;
import com.example.musicalist.respositories.UsuarioVotanteRepository;
import com.example.musicalist.respositories.VotoRepository;

@Service
public class VotoService {

   
    @Autowired
    VotoRepository votoRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    UsuarioVotanteRepository usuarioVotanteRepository;

    public Voto insertar(VotoDTO votoDTO){

        Track track = retrieveTrack(votoDTO.getTrack_id());

        
        UsuarioVotante usuarioVotante = retrieveUsuarioVotante(votoDTO.getId());

        if (track != null && usuarioVotante != null) {
            
            Voto voto = new Voto(track, usuarioVotante);

            
            return votoRepository.save(voto);
        } else {
            
            return null;
        }

    }

    private Track retrieveTrack(Long trackId) {
        
        return trackRepository.findById(trackId).orElse(null);
    }

    private UsuarioVotante retrieveUsuarioVotante(Long usuarioVotanteId) {
        
        return usuarioVotanteRepository.findById(usuarioVotanteId).orElse(null);
    }

    public Voto actualizar(Voto voto){

        return votoRepository.save(voto);
    }

    public List<VotoDTO> listar(){
                List<Object[]> results = votoRepository.listar();

                
for (Object[] result : results) {
    for (Object obj : result) {
        System.out.println(obj);
    }
}
                
                List<VotoDTO> votoDTOs = new ArrayList<>();
                
                for (Object[] result : results) {
                    
                    BigInteger trackId = (BigInteger) result[0];
                    String duration = (String) result[1]; 
            
                    String title = (String) result[2];

                    BigInteger id_album = (BigInteger) result[3];
                    Optional<Album> album = albumRepository.findById(id_album.longValue());
                    
                    Integer usuarioVotanteId = (Integer) result[4];
                    
                    String nombre = (String) result[5];
                    String contrasena = (String) result[6];
                    String correo = (String) result[7];
                    String nombrePerfil = (String) result[8];
                    
                    
                    Track trackEntity = new Track();
                    trackEntity.setTrack_id(trackId.longValue());
                    trackEntity.setTitle(title);
                    trackEntity.setAlbum(album.get());
                    UsuarioVotante usuarioVotante = new UsuarioVotante();
                    usuarioVotante.setId(usuarioVotanteId.longValue());
                    usuarioVotante.setNombre(nombre);
                    usuarioVotante.setContrasena(contrasena);
                    usuarioVotante.setCorreo(correo);
                    usuarioVotante.setNombrePerfil(nombrePerfil);
                    
                    
                    VotoDTO votoDTO = new VotoDTO();
                    votoDTO.setId(usuarioVotanteId.longValue());
                    votoDTO.setTrack_id(trackId.longValue());
                    votoDTO.setTrack(trackEntity);
                    votoDTO.setUsuarioVotante(usuarioVotante);
                
                
                    votoDTOs.add(votoDTO);
                }
        return votoDTOs;
        
    }

    }

    


    

