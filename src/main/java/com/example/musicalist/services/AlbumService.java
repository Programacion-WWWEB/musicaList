package com.example.musicalist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.AlbumDTO;
import com.example.musicalist.DTOs.TrackDTO;
import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.TrackRepository;

@Service
public class AlbumService{
    
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    ModelMapper modelMapper;

    public Album insertar(Album album){
        List<Track> track = album.getTrackListing();
        for (Track track2 : track) {
            trackRepository.save(track2);
        }
        return albumRepository.save(album);
    };

    public Album actualizar(Album album){
        return albumRepository.save(album);
    };

    public AlbumDTO buscar(Long id){
        Optional<Album>AlbumOptional =  albumRepository.findById(id);
		Album Album = null;
		AlbumDTO AlbumDTO = null;
		if( AlbumOptional.isPresent() ) {
			Album = AlbumOptional.get();
			AlbumDTO = modelMapper.map(Album, AlbumDTO.class);
		}
		return AlbumDTO;
    };

    public List<AlbumDTO> listar() {
        Iterable<Album> albums = albumRepository.findAll();
        List<AlbumDTO> albumDTOs = new ArrayList<>();

        for (Album album : albums) {
            AlbumDTO albumDTO = modelMapper.map(album, AlbumDTO.class);

            
            List<Track> tracks = (List<Track>) trackRepository.findByAlbum(album.getAlbum_id());
            List<TrackDTO> trackDTOs = new ArrayList<>();

            for (Track track : tracks) {
                TrackDTO trackDTO = modelMapper.map(track, TrackDTO.class);
                trackDTOs.add(trackDTO);
            }

            albumDTO.setTrackListing(trackDTOs);
            albumDTOs.add(albumDTO);
        }

        return albumDTOs;
    }

    public void eliminar(Album album){
        albumRepository.delete(album);
    };

    public void eliminar(Long id){
        albumRepository.deleteById(id);
    };

}
