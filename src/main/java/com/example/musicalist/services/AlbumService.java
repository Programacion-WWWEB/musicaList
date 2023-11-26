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

    public Album insertar(AlbumDTO albumDTO){

        Album album = new Album();
    album.setName(albumDTO.getName());
    album.setArtist(albumDTO.getArtist());
    album.setType(albumDTO.getType());
    album.setRelease_date(albumDTO.getRelease_date());
    album.setRym_rating(albumDTO.getRym_rating());
    album.setLanguage(albumDTO.getLanguage());
    album.setGenres(albumDTO.getGenres());
    album.setColorscheme(albumDTO.getColorscheme());

    if (albumDTO.getTrackListing() != null) {
        List<Track> tracks = new ArrayList<>();

        for (TrackDTO trackDTO : albumDTO.getTrackListing()) {
            Track track = new Track();
            track.setTitle(trackDTO.getTitle());
            track.setDuration(trackDTO.getDuration());
            track.setTrack_id(trackDTO.getTrack_id());
            track.setAlbum(trackDTO.getAlbum());
            tracks.add(track);
        }
        album.setTrackListing(tracks);
        
        for (Track track : tracks) {
            trackRepository.save(track);
        }
        }
        return albumRepository.save(album);
    }

    public Album actualizar(Album album){
        return albumRepository.save(album);
    }

    public AlbumDTO buscar(Long id){
        Optional<Album> albumOptional =  albumRepository.findById(id);
		Album album = null;
		AlbumDTO albumDTO = null;
		if( albumOptional.isPresent() ) {
			album = albumOptional.get();
			albumDTO = modelMapper.map(album, AlbumDTO.class);
		}
		return albumDTO;
    }

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
    }

    public void eliminar(Long id){
        albumRepository.deleteById(id);
    }

}
