package com.example.musicalist.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotoRepository extends JpaRepository<Voto,Long> {


       @Query(value = "SELECT t.*, u.* FROM track t JOIN Voto v ON t.track_id = v.track_id JOIN usuario_votante u ON v.id = u.id WHERE t.title=?1 AND u.nombre = ?2", nativeQuery = true)
    List<Voto> findUserVoto(String track, String voto);

    
}
