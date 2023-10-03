package com.example.musicalist.modelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

    @Query(value = "SELECT * FROM album WHERE name = ?1", nativeQuery = true)
    Optional<Album> findAlbumByName(String name);
     
}
