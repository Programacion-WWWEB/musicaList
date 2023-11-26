package com.example.musicalist;
import static org.assertj.core.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.TrackRepository;

@SpringBootTest
@Transactional
public class TrackFromAlbumTests {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Test
    public void testCreateAlbumAndTrack() {
        
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
        
        Track track = new Track();
        track.setTitle("La Balsa");
        track.setDuration(923000L);
        track.setAlbum(album);
        
        
        album.getTrackListing().add(track);
        

        
        Optional<Album> retrievedAlbum = albumRepository.findAlbumByName("Los Gatos");
        assertThat(retrievedAlbum).isPresent();

        
        Iterable<Track> tracksForAlbum = trackRepository.findByAlbum(retrievedAlbum.get().getAlbum_id());
        assertThat(tracksForAlbum).isNotEmpty();

    
        Track retrievedTrack = tracksForAlbum.iterator().next();
        assertThat(retrievedTrack.getTitle()).isEqualTo("La Balsa");
    }
    
}
