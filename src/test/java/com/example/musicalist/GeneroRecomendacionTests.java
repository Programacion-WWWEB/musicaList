package com.example.musicalist;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Genero;
import com.example.musicalist.modelo.Recomendacion;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.GeneroRepository;
import com.example.musicalist.respositories.RecomendacionRepository;
@SpringBootTest
@Transactional
public class GeneroRecomendacionTests {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private AlbumRepository albumRepository;
    
    @Test
    public void recomendarTest(){

          Album album = new Album();
        album.setName("Los Gatos");
        album.setArtist("Los Gatos");
        album.setType("Album");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = new Date();
        
        try {dateFormat.parse("1967-11-11"); 
        album.setRelease_date(releaseDate);}
        catch(ParseException e){

            e.printStackTrace();
        }
        album.setRym_rating(4.5f);
        album.setLanguage("Spanish");
        albumRepository.save(album);
        Genero genero = new Genero();
        genero.setName("Sunshine pop");
        generoRepository.save(genero);

        Recomendacion recomendacion = new Recomendacion(album,genero);
        recomendacionRepository.save(recomendacion);
        List<Recomendacion> founRecomendacions = recomendacionRepository.findByGeneroAndAlbum(album.getName(),genero.getName());
        assertFalse((founRecomendacions).isEmpty());
        


    }
    
}
