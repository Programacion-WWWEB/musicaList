package com.example.musicalist.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioVotanteService{
    
    @Autowired
    private UsuarioVotanteRepository UsuarioVotanteRepository;

    public UsuarioVotante insertar(UsuarioVotante usuario){
        return UsuarioVotanteRepository.save(usuario);
    };

    public UsuarioVotante actualizar(UsuarioVotante usuario){
        return UsuarioVotanteRepository.save(usuario);
    };

    public List<UsuarioVotante> listar(){
        return UsuarioVotanteRepository.findAll();
    };

    public void eliminar(UsuarioVotante usuario){
        UsuarioVotanteRepository.delete(usuario);
    };

}
