package com.example.musicalist.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musicalist.DTOs.UsuarioAdministradorDTO;
import com.example.musicalist.modelo.UsuarioAdministrador;
import com.example.musicalist.respositories.UsuarioAdministradorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAdministradorService{
    
    @Autowired
    private UsuarioAdministradorRepository UsuarioAdministradorRepository;

    @Autowired
    ModelMapper modelMapper;

    public UsuarioAdministrador insertar(UsuarioAdministrador UsuarioAdministrador){
        return UsuarioAdministradorRepository.save(UsuarioAdministrador);
    };

    public UsuarioAdministrador actualizar(UsuarioAdministrador UsuarioAdministrador){
        return UsuarioAdministradorRepository.save(UsuarioAdministrador);
    };

    public UsuarioAdministradorDTO buscar(Long id){
        Optional<UsuarioAdministrador>UsuarioAdministradorOptional =  UsuarioAdministradorRepository.findById(id);
		UsuarioAdministrador UsuarioAdministrador = null;
		UsuarioAdministradorDTO UsuarioAdministradorDTO = null;
		if( UsuarioAdministradorOptional.isPresent() ) {
			UsuarioAdministrador = UsuarioAdministradorOptional.get();
			UsuarioAdministradorDTO = modelMapper.map(UsuarioAdministrador, UsuarioAdministradorDTO.class);
		}
		return UsuarioAdministradorDTO;
    };

    public List<UsuarioAdministradorDTO> listar(){
        Iterable<UsuarioAdministrador> UsuarioAdministradors = UsuarioAdministradorRepository.findAll();
		List<UsuarioAdministradorDTO> UsuarioAdministradorDTO = new ArrayList<UsuarioAdministradorDTO>();
		
		for (UsuarioAdministrador UsuarioAdministrador : UsuarioAdministradors) {
			UsuarioAdministradorDTO.add(modelMapper.map(UsuarioAdministrador, UsuarioAdministradorDTO.class) );
		}
		
        return UsuarioAdministradorDTO;
        
    };

    public void eliminar(UsuarioAdministrador UsuarioAdministrador){
        UsuarioAdministradorRepository.delete(UsuarioAdministrador);
    };

    public void eliminar(Long id){
        UsuarioAdministradorRepository.deleteById(id);
    };

}