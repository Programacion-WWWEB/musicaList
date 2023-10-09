package com.example.musicalist;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.modelo.Voto;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.TrackRepository;
import com.example.musicalist.respositories.UsuarioVotanteRepository;
import com.example.musicalist.respositories.VotoRepository;


@SpringBootTest
@Transactional
public class VotoCancionTests {

    @Autowired
    UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    private AlbumRepository albumRepository;
    
    @Test
    public void testVotoUsuario(){
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

        
        Track track = new Track();
        track.setTitle("La Balsa");
        track.setDuration(Time.valueOf("00:03:30"));
        track.setAlbum(album);

        
        album.getTrackListing().add(track);
        albumRepository.save(album);
        trackRepository.save(track);

        UsuarioVotante user = new UsuarioVotante();
        user.setNombre("nombre");
        user.setNombrePerfil("perfil");
        user.setCorreo("correo@gmail.com");
        user.setContrasena("contrasena");
        usuarioVotanteRepository.save(user);

        Voto voto = new Voto(track,user);
        votoRepository.save(voto);
        
        List<Voto> votosHechos =  votoRepository.findUserVoto(track.getTitle(),user.getNombre());
        
        assertFalse(votosHechos.isEmpty());

    }

    
}
