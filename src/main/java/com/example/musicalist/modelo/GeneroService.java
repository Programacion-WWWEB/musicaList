package com.example.musicalist.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeneroService{
    
    @Autowired
    private GeneroRepository generoRepository;

    public Genero insertar(Genero usuario){
        return generoRepository.save(usuario);
    };

    public Genero actualizar(Genero usuario){
        return generoRepository.save(usuario);
    };

    public List<Genero> listar(){
        return generoRepository.findAll();
    };

    public void eliminar(Genero usuario){
        generoRepository.delete(usuario);
    };

}
