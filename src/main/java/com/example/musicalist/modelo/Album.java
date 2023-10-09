package com.example.musicalist.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(exclude = "album_id")
public class Album {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    
    @Getter @Setter
    @JsonIgnore
    private List<Track> trackListing = new ArrayList<>(); 

    @OneToMany(mappedBy = "album")
    private Set<Recomendacion> recomendar = new HashSet<>();

    
}
