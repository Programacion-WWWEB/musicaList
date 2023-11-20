package com.example.musicalist.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.musicalist.modelo.UsuarioAdministrador;


@Repository
public interface UsuarioAdministradorRepository extends JpaRepository<UsuarioAdministrador, Long>{

    @Query("SELECT u FROM UsuarioAdministrador u WHERE u.nombre = ?1 AND u.contrasena = ?2")
    Optional<UsuarioAdministrador> findUserByNombrePerfilAndContrasena(String nombrePerfil, String contrasena); 
    
}
