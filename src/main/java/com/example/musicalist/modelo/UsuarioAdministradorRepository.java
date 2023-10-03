package com.example.musicalist.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAdministradorRepository extends JpaRepository<UsuarioAdministrador, Long>{
    
}
