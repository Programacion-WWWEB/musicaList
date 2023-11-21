package com.example.musicalist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.respositories.UsuarioVotanteRepository;

@Service
public class UsuarioVotanteService{
    
    @Autowired
    private UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    ModelMapper modelMapper;

    public UsuarioVotante insertar(UsuarioVotante usuarioVotante){
        return usuarioVotanteRepository.save(usuarioVotante);
    }

    public UsuarioVotante actualizar(UsuarioVotante usuarioVotante){
        return usuarioVotanteRepository.save(usuarioVotante);
    }

    public UsuarioVotanteDTO buscar(Long id){
        Optional<UsuarioVotante>usuarioVotanteOptional =  usuarioVotanteRepository.findById(id);
		UsuarioVotante usuarioVotante = null;
		UsuarioVotanteDTO usuarioVotanteDTO = null;
		if( usuarioVotanteOptional.isPresent() ) {
			usuarioVotante = usuarioVotanteOptional.get();
			usuarioVotanteDTO = modelMapper.map(usuarioVotante, UsuarioVotanteDTO.class);
		}
		return usuarioVotanteDTO;
    }

    public List<UsuarioVotanteDTO> listar(){
        Iterable<UsuarioVotante> usuarioVotantes = usuarioVotanteRepository.findAll();
		List<UsuarioVotanteDTO> usuarioVotanteDTO = new ArrayList<UsuarioVotanteDTO>();
		
		for (UsuarioVotante usuarioVotante : usuarioVotantes) {
			usuarioVotanteDTO.add(modelMapper.map(usuarioVotante, UsuarioVotanteDTO.class) );
		}
		
        return usuarioVotanteDTO;
        
    }

    public void eliminar(UsuarioVotante usuarioVotante){
        usuarioVotanteRepository.delete(usuarioVotante);
    }

    public void eliminar(Long id){
        usuarioVotanteRepository.deleteById(id);
    }

}
