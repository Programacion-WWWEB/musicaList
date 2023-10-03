package com.example.musicalist.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService{
    
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public Track insertar(Track track){
        Optional<Album> album = albumRepository.findById(track.getAlbum().getAlbum_id());
        if(album.isPresent()){
            track.setAlbum(album.get());
            return trackRepository.save(track);
        }
        return null;
    };

    public Track actualizar(Track track){
        Optional<Album> album = albumRepository.findById(track.getAlbum().getAlbum_id());
        if(!album.isPresent()){
            return null;
        }
        track.setAlbum(album.get());
        return trackRepository.save(track);
    };

    public List<Track> listar(){
        return trackRepository.findAll();
    };

    public void eliminar(Track track){
        trackRepository.delete(track);
    };

}
