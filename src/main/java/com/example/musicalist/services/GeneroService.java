package com.example.musicalist.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.GeneroDTO;
import com.example.musicalist.DTOs.GeneroDTO;
import com.example.musicalist.modelo.Genero;
import com.example.musicalist.modelo.Genero;
import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.GeneroRepository;
import com.example.musicalist.respositories.GeneroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroService{
    
    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    ModelMapper modelMapper;

    public Genero insertar(Genero usuario){
        return generoRepository.save(usuario);
    };

    public Genero actualizar(Genero usuario){
        return generoRepository.save(usuario);
    };

    public List<GeneroDTO> listar(){
        Iterable<Genero> Generos = generoRepository.findAll();
		List<GeneroDTO> GeneroDTO = new ArrayList<GeneroDTO>();
		
		for (Genero Genero : Generos) {
			GeneroDTO.add(modelMapper.map(Genero, GeneroDTO.class) );
		}
		
        return GeneroDTO;
    }

    public GeneroDTO buscar(Long id){
        Optional<Genero>GeneroOptional =  generoRepository.findById(id);
		Genero Genero = null;
		GeneroDTO GeneroDTO = null;
		if( GeneroOptional.isPresent() ) {
			Genero = GeneroOptional.get();
			GeneroDTO = modelMapper.map(Genero, GeneroDTO.class);
		}
		return GeneroDTO;
    };

    public void eliminar(Genero usuario){
        generoRepository.delete(usuario);
    };

    public void eliminar(Long id){
        generoRepository.deleteById(id);
    };
}
