package com.example.musicalist;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.musicalist.modelo.UsuarioAdministrador;
import com.example.musicalist.respositories.UsuarioAdministradorRepository;

@SpringBootTest
public class UsuarioAdministradorTests {

    @Autowired
    protected UsuarioAdministradorRepository usuarioAdministradorRepository;

    @Test
    @Transactional
    void insertarAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        assertTrue(true);

    }

    @Test
    @Transactional
    void actualizarAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        assertTrue(true);

    }

    @Test
    @Transactional
    void buscarAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        usuarioAdministradorRepository.findById(usuarioAdministrador.getId());
        assertTrue(true);

    }

    @Test
    @Transactional
    void listarAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        usuarioAdministradorRepository.findAll();
        assertTrue(true);

    }

    @Test
    @Transactional
    void eliminarAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        usuarioAdministradorRepository.delete(usuarioAdministrador);
        assertTrue(true);

    }

    @Test
    @Transactional
    void eliminarIdAdmin(){

        UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador();
        usuarioAdministrador.setNombre("admin");
        usuarioAdministrador.setContrasena("Nueva_Contrasena981228");
        usuarioAdministradorRepository.save(usuarioAdministrador);
        usuarioAdministradorRepository.deleteById(usuarioAdministrador.getId());
        assertTrue(true);

    }
}
