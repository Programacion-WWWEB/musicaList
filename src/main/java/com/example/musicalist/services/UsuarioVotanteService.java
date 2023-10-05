package com.example.musicalist.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.respositories.UsuarioVotanteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioVotanteService{
    
    @Autowired
    private UsuarioVotanteRepository UsuarioVotanteRepository;

    @Autowired
    ModelMapper modelMapper;

    public UsuarioVotante insertar(UsuarioVotante UsuarioVotante){
        return UsuarioVotanteRepository.save(UsuarioVotante);
    };

    public UsuarioVotante actualizar(UsuarioVotante UsuarioVotante){
        return UsuarioVotanteRepository.save(UsuarioVotante);
    };

    public UsuarioVotanteDTO buscar(Long id){
        Optional<UsuarioVotante>UsuarioVotanteOptional =  UsuarioVotanteRepository.findById(id);
		UsuarioVotante UsuarioVotante = null;
		UsuarioVotanteDTO UsuarioVotanteDTO = null;
		if( UsuarioVotanteOptional.isPresent() ) {
			UsuarioVotante = UsuarioVotanteOptional.get();
			UsuarioVotanteDTO = modelMapper.map(UsuarioVotante, UsuarioVotanteDTO.class);
		}
		return UsuarioVotanteDTO;
    };

    public List<UsuarioVotanteDTO> listar(){
        Iterable<UsuarioVotante> UsuarioVotantes = UsuarioVotanteRepository.findAll();
		List<UsuarioVotanteDTO> UsuarioVotanteDTO = new ArrayList<UsuarioVotanteDTO>();
		
		for (UsuarioVotante UsuarioVotante : UsuarioVotantes) {
			UsuarioVotanteDTO.add(modelMapper.map(UsuarioVotante, UsuarioVotanteDTO.class) );
		}
		
        return UsuarioVotanteDTO;
        
    };

    public void eliminar(UsuarioVotante UsuarioVotante){
        UsuarioVotanteRepository.delete(UsuarioVotante);
    };

    public void eliminar(Long id){
        UsuarioVotanteRepository.deleteById(id);
    };

}
