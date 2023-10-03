package com.example.musicalist.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumService{
    
    @Autowired
    private AlbumRepository AlbumRepository;

    public Album insertar(Album album){
        return AlbumRepository.save(album);
    };

    public Album actualizar(Album album){
        return AlbumRepository.save(album);
    };

    public List<Album> listar(){
        return AlbumRepository.findAll();
    };

    public void eliminar(Album album){
        AlbumRepository.delete(album);
    };

}
