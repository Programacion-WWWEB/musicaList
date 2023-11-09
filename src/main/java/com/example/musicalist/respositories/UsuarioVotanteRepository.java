package com.example.musicalist.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.musicalist.modelo.UsuarioVotante;

@Repository
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public interface UsuarioVotanteRepository extends JpaRepository<UsuarioVotante,Long> {

    @Query("SELECT u FROM UsuarioVotante u WHERE u.nombrePerfil = ?1")
    Optional<UsuarioVotante> findUserByNombrePerfil(String nombrePerfil);

    @Query("SELECT u FROM UsuarioVotante u WHERE u.nombrePerfil = ?1 AND u.contrasena = ?2")
    Optional<UsuarioVotante> findUserByNombrePerfilAndContrasena(String nombrePerfil, String contrasena);    
    
}
