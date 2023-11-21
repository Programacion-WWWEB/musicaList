package com.example.musicalist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.GeneroDTO;
import com.example.musicalist.modelo.Genero;
import com.example.musicalist.respositories.GeneroRepository;

@Service
public class GeneroService{
    
    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    ModelMapper modelMapper;

    public Genero insertar(Genero usuario){
        return generoRepository.save(usuario);
    }

    public Genero actualizar(Genero usuario){
        return generoRepository.save(usuario);
    }

    public List<GeneroDTO> listar(){
        Iterable<Genero> generos = generoRepository.findAll();
		List<GeneroDTO> generoDTO = new ArrayList<GeneroDTO>();
		
		for (Genero genero : generos) {
			generoDTO.add(modelMapper.map(genero, GeneroDTO.class) );
		}
		
        return generoDTO;
    }

    public GeneroDTO buscar(Long id){
        Optional<Genero> generoOptional =  generoRepository.findById(id);
		Genero genero = null;
		GeneroDTO generoDTO = null;
		if( generoOptional.isPresent() ) {
			genero = generoOptional.get();
			generoDTO = modelMapper.map(genero, GeneroDTO.class);
		}
		return generoDTO;
    }

    public void eliminar(Genero usuario){
        generoRepository.delete(usuario);
    }

    public void eliminar(Long id){
        generoRepository.deleteById(id);
    }
}
