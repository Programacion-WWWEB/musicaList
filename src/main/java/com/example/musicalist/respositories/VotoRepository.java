package com.example.musicalist.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.musicalist.modelo.Voto;

public interface VotoRepository extends JpaRepository<Voto,Long> {


       @Query(value = "SELECT t.*, u.* FROM track t JOIN voto v ON t.track_id = v.track_id JOIN usuario_votante u ON v.id = u.id WHERE t.title=?1 AND u.nombre = ?2", nativeQuery = true)
    List<Voto> findUserVoto(String track, String voto);

     @Query(value = "SELECT t.*, u.* FROM track t JOIN voto v ON t.track_id = v.track_id JOIN usuario_votante u ON v.id = u.id WHERE t.title=?1 AND u.nombre = ?2", nativeQuery = true)
    List<Object[]> sqlFindByNames(String track, String voto);

    @Query(value = "SELECT t.*, u.* FROM track t JOIN voto v ON t.track_id = v.track_id JOIN usuario_votante u ON v.id = u.id" , nativeQuery = true)
    List<Object[]> listar();

    
}
