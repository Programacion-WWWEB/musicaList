package com.example.musicalist.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.musicalist.modelo.Track;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface TrackRepository extends JpaRepository<Track,Long> {
    
    @Query(value = "SELECT * from track WHERE album_id = ?1", nativeQuery = true)
    public Iterable<Track> findByAlbum( @Param("album_id") Long albumId);
}
