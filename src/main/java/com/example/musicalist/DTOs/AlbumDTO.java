package com.example.musicalist.DTOs;

import java.util.Date;


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
    
}
