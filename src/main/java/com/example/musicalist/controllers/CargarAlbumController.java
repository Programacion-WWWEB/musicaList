package com.example.musicalist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.respositories.AlbumRepository;
import com.example.musicalist.respositories.TrackRepository;;

@RestController
public class CargarAlbumController {
    

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    TrackRepository trackRepository;


    
    
}
