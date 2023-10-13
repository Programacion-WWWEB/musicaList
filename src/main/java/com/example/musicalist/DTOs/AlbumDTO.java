package com.example.musicalist.DTOs;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.musicalist.modelo.Recomendacion;

import lombok.Getter;
import lombok.Setter;

public class AlbumDTO {

    @Getter @Setter
    private Long album_id;
    
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String artist;
    
    @Getter @Setter
    private String type;
    
    @Getter @Setter
    private Date release_date;
    
    @Getter @Setter
    private Float rym_rating;
    
    @Getter @Setter
    private String language;
    
    @Getter @Setter
    private String genres;

    @Getter @Setter
    private String colorscheme;

    @Getter @Setter
    private List<TrackDTO> trackListing;
    
    @Getter @Setter
    private Set<Recomendacion> recomendar = new HashSet<>();
    
}
