package com.example.musicalist.DTOs;

import com.example.musicalist.modelo.Album;

import lombok.Getter;
import lombok.Setter;

public class TrackDTO {
    @Getter @Setter
    private Long track_id;
     
    @Getter @Setter
    private String title;

    @Getter @Setter
    private Long duration; 

     @Getter @Setter
    private Album album;


}
