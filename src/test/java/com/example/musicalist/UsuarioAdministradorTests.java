package com.example.musicalist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.musicalist.modelo.UsuarioAdministrador;
import com.example.musicalist.modelo.UsuarioAdministradorRepository;

@SpringBootTest
public class UsuarioAdministradorTests {

    @Autowired
    protected UsuarioAdministradorRepository usuarioAdministradorRepository;

    @Test
    void insertarAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        assertTrue(true);

    }


    
}
