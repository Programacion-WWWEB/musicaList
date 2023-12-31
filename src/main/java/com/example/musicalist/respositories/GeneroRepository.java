package com.example.musicalist.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.musicalist.modelo.Genero;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface GeneroRepository extends JpaRepository<Genero, Long>{

    @Query(value = "SELECT * FROM Genero WHERE name = ?1", nativeQuery = true)
    Optional<Genero> findGeneroByNombre(String nombre);
    
    @Query(value = "SELECT * FROM Genero", nativeQuery = true)
    Optional<Genero> loadGeneros();

}
