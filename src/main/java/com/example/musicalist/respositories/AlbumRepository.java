package com.example.musicalist.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.musicalist.modelo.Album;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface AlbumRepository extends JpaRepository<Album, Long>{

    @Query(value = "SELECT * FROM album WHERE name = ?1", nativeQuery = true)
    Optional<Album> findAlbumByName(String name);

    @Query(value = "SELECT * FROM album", nativeQuery = true)
    Optional<Album> loadAlbum();
     
}
