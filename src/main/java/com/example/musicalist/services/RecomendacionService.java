package com.example.musicalist.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.RecomendacionDTO;
import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Genero;
import com.example.musicalist.modelo.Recomendacion;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.GeneroRepository;
import com.example.musicalist.respositories.RecomendacionRepository;

@Service
public class RecomendacionService {
    
    @Autowired
    RecomendacionRepository recomendacionRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    GeneroRepository generoRepository;

    @Autowired
    ModelMapper modelMapper;

     public Recomendacion insertar(RecomendacionDTO recomendacionDTO){

        Album album = retrieveAlbum(recomendacionDTO.getAlbum_id());

        
        Genero genero = retrieveGenero(recomendacionDTO.getId());

        if (album != null && genero != null) {
            
            Recomendacion recomendacion = new Recomendacion(album, genero);

            
            return recomendacionRepository.save(recomendacion);
        } else {
            
            return null;
        }

    }

    private Album retrieveAlbum(Long albumId) {
        
        return albumRepository.findById(albumId).orElse(null);
    }

    private Genero retrieveGenero(Long usuarioVotanteId) {
        
        return generoRepository.findById(usuarioVotanteId).orElse(null);
    } 

    public List<RecomendacionDTO> listar(){
        List<Object[]> results = recomendacionRepository.recomendarLoad();

        for (Object[] result : results) {
            for (Object obj : result) {
                System.out.println(obj);
            }
        }

        List<RecomendacionDTO> recmendacionDTOs = new ArrayList<>();

        for(Object[] result : results){

            Album albumEntity = new Album();

            Integer albumId = (Integer) result[0];
            albumEntity.setAlbum_id(albumId.longValue());

            String name = (String) result[1];
            albumEntity.setName(name);

            String artist = (String) result[2];
            albumEntity.setArtist(artist);

            String type = (String) result[3];
            albumEntity.setType(type);

            Date date = (Date) result[4];
            albumEntity.setRelease_date(date);

            BigDecimal rymRating = (BigDecimal) result[5];
            albumEntity.setRym_rating(rymRating.floatValue());

            String genres = (String) result[6];
            albumEntity.setGenres(genres);

            String language = (String) result[7];
            albumEntity.setLanguage(language);

            String colorScheme = (String) result[8];
            albumEntity.setColorscheme(colorScheme);

            Genero generoEntity = new Genero();

            Integer idGenero = (Integer) result[9];
            generoEntity.setId(idGenero.longValue());

            String nombre = (String) result[10];
            generoEntity.setNombre(nombre);
            RecomendacionDTO recomendacionDTO = new RecomendacionDTO();
            recomendacionDTO.setAlbum(albumEntity);
            recomendacionDTO.setGenero(generoEntity);
            recomendacionDTO.setAlbum_id(albumId.longValue());
            recomendacionDTO.setId(idGenero.longValue());

            recmendacionDTOs.add(recomendacionDTO);
        }

        return recmendacionDTOs;


        
    }




}
