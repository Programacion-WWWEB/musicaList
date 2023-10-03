package com.example.musicalist.modelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioVotanteRepository extends JpaRepository<UsuarioVotante,Long> {

    @Query("SELECT u FROM UsuarioVotante u WHERE u.nombrePerfil = ?1")
    Optional<UsuarioVotante> findUserByNombrePerfil(String nombrePerfil);
    
}
