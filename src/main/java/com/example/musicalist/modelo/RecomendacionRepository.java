package com.example.musicalist.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecomendacionRepository extends JpaRepository<Recomendacion,Long> {
    
    @Query(value = "SELECT a.*, g.* FROM album a JOIN recomendacion r ON a.album_id = r.album_id JOIN genero g ON r.id = g.id", nativeQuery = true)
List<Recomendacion> findByGeneroAndAlbum(String generoNombre, String albumName);

}

