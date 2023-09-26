package com.example.musicalist;
import static org.assertj.core.api.Assertions.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.musicalist.modelo.Album;
import com.example.musicalist.modelo.AlbumRepository;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.TrackRepository;

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
        album.setReleaseDate(releaseDate);}
        catch(ParseException e){

            e.printStackTrace();
        }
        album.setRymRating(4.5f);
        album.setLanguague("Spanish");

        
        Track track = new Track();
        track.setTitle("La Balsa");
        track.setDuration(Time.valueOf("00:03:30"));
        track.setAlbum(album);

        
        album.getTrackListing().add(track);
        albumRepository.save(album);

        
        Optional<Album> retrievedAlbum = albumRepository.findAlbumByName("Los Gatos");
        assertThat(retrievedAlbum).isPresent();

        
        Iterable<Track> tracksForAlbum = trackRepository.findByAlbum(retrievedAlbum.get().getAlbumId());
        assertThat(tracksForAlbum).isNotEmpty();

    
        Track retrievedTrack = tracksForAlbum.iterator().next();
        assertThat(retrievedTrack.getTitle()).isEqualTo("La Balsa");
    }
    
}
