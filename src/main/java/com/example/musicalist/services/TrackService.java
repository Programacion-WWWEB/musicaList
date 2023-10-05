package com.example.musicalist.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.TrackDTO;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.respositories.TrackRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService{
    
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    ModelMapper modelMapper;

    public Track insertar(Track Track){
        return trackRepository.save(Track);
    };

    public Track actualizar(Track Track){
        return trackRepository.save(Track);
    };

    public TrackDTO buscar(Long id){
        Optional<Track>TrackOptional =  trackRepository.findById(id);
		Track Track = null;
		TrackDTO TrackDTO = null;
		if( TrackOptional.isPresent() ) {
			Track = TrackOptional.get();
			TrackDTO = modelMapper.map(Track, TrackDTO.class);
		}
		return TrackDTO;
    };

    public List<TrackDTO> listar(){
        Iterable<Track> Tracks = trackRepository.findAll();
		List<TrackDTO> TrackDTO = new ArrayList<TrackDTO>();
		
		for (Track Track : Tracks) {
			TrackDTO.add(modelMapper.map(Track, TrackDTO.class) );
		}
		
        return TrackDTO;
        
    };

    public List<TrackDTO> listar(Long id){
        Iterable<Track> Tracks = trackRepository.findByAlbum(id);
		List<TrackDTO> TrackDTO = new ArrayList<TrackDTO>();
		
		for (Track Track : Tracks) {
			TrackDTO.add(modelMapper.map(Track, TrackDTO.class) );
		}
		
        return TrackDTO;
        
    };

    public void eliminar(Track Track){
        trackRepository.delete(Track);
    };

    public void eliminar(Long id){
        trackRepository.deleteById(id);
    };

}
