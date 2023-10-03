package com.example.musicalist.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioAdministradorService{
    
    @Autowired
    private UsuarioAdministradorRepository usuarioAdministradorRepository;

    public UsuarioAdministrador insertar(UsuarioAdministrador usuario){
        return usuarioAdministradorRepository.save(usuario);
    };

    public UsuarioAdministrador actualizar(UsuarioAdministrador usuario){
        return usuarioAdministradorRepository.save(usuario);
    };

    public List<UsuarioAdministrador> listar(){
        return usuarioAdministradorRepository.findAll();
    };

    public void eliminar(UsuarioAdministrador usuario){
        usuarioAdministradorRepository.delete(usuario);
    };

}
