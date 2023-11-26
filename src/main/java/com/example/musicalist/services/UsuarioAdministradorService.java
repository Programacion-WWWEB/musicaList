package com.example.musicalist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.UsuarioAdministradorDTO;
import com.example.musicalist.modelo.UsuarioAdministrador;
import com.example.musicalist.respositories.UsuarioAdministradorRepository;

@Service
public class UsuarioAdministradorService{
    
    @Autowired
    private UsuarioAdministradorRepository usuarioAdministradorRepository;

    @Autowired
    ModelMapper modelMapper;

    public UsuarioAdministrador insertar(UsuarioAdministrador usuarioAdministrador){
        return usuarioAdministradorRepository.save(usuarioAdministrador);
    }

    public UsuarioAdministrador actualizar(UsuarioAdministrador UsuarioAdministrador){
        return usuarioAdministradorRepository.save(UsuarioAdministrador);
    }

    public UsuarioAdministradorDTO buscar(Long id){
        Optional<UsuarioAdministrador>usuarioAdministradorOptional =  usuarioAdministradorRepository.findById(id);
		UsuarioAdministrador usuarioAdministrador = null;
		UsuarioAdministradorDTO usuarioAdministradorDTO = null;
		if( usuarioAdministradorOptional.isPresent() ) {
			usuarioAdministrador = usuarioAdministradorOptional.get();
			usuarioAdministradorDTO = modelMapper.map(usuarioAdministrador, UsuarioAdministradorDTO.class);
		}
		return usuarioAdministradorDTO;
    }

    public List<UsuarioAdministradorDTO> listar(){
        Iterable<UsuarioAdministrador> usuarioAdministradors = usuarioAdministradorRepository.findAll();
		List<UsuarioAdministradorDTO> usuarioAdministradorDTO = new ArrayList<UsuarioAdministradorDTO>();
		
		for (UsuarioAdministrador usuarioAdministrador : usuarioAdministradors) {
			usuarioAdministradorDTO.add(modelMapper.map(usuarioAdministrador, UsuarioAdministradorDTO.class) );
		}
		
        return usuarioAdministradorDTO;
        
    }

    public void eliminar(UsuarioAdministrador usuarioAdministrador){
        usuarioAdministradorRepository.delete(usuarioAdministrador);
    }

    public void eliminar(Long id){
        usuarioAdministradorRepository.deleteById(id);
    }

}