package com.example.musicalist.modelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeneroRepository extends JpaRepository<Genero, Long>{

    @Query(value = "SELECT * FROM Genero WHERE nombre = ?1", nativeQuery = true)
    Optional<Genero> findGeneroByNombre(String nombre);
    
    @Query(value = "SELECT * FROM Genero", nativeQuery = true)
    Optional<Genero> loadGeneros();

}
