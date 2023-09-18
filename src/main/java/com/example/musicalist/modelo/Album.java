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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(exclude = "albumId")
public class Album {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String artist;
    
    @Getter @Setter
    private String type;
    
    @Getter @Setter
    private Date releaseDate;
    
    @Getter @Setter
    private Float rymRating;
    
    @Getter @Setter
    private String languague;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trackId")
    private List<Track> trackListing = new ArrayList<>(); 

    @OneToMany(mappedBy = "album")
    private Set<Recomendacion> recomendar = new HashSet<>();

    
}
