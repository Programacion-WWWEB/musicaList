package com.example.musicalist.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.AlbumDTO;
import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.TrackRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService{
    
    @Autowired
    private AlbumRepository AlbumRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    ModelMapper modelMapper;

    public Album insertar(Album album){
        List<Track> track = album.getTrackListing();
        for (Track track2 : track) {
            trackRepository.save(track2);
        }
        return AlbumRepository.save(album);
    };

    public Album actualizar(Album album){
        return AlbumRepository.save(album);
    };

    public AlbumDTO buscar(Long id){
        Optional<Album>AlbumOptional =  AlbumRepository.findById(id);
		Album Album = null;
		AlbumDTO AlbumDTO = null;
		if( AlbumOptional.isPresent() ) {
			Album = AlbumOptional.get();
			AlbumDTO = modelMapper.map(Album, AlbumDTO.class);
		}
		return AlbumDTO;
    };

    public List<AlbumDTO> listar(){
        Iterable<Album> albums = AlbumRepository.findAll();
		List<AlbumDTO> albumDTO = new ArrayList<AlbumDTO>();
		
		for (Album album : albums) {
			albumDTO.add(modelMapper.map(album, AlbumDTO.class) );
		}
		
        return albumDTO;
        
    };

    public void eliminar(Album album){
        AlbumRepository.delete(album);
    };

    public void eliminar(Long id){
        AlbumRepository.deleteById(id);
    };

}
