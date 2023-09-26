package com.example.musicalist.modelo;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity

public class Track {
     

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Long track_id;
     
    @Getter @Setter
    private String title;

    @Getter @Setter
    private Time duration;

    @ManyToOne()
    @JoinColumn(name = "album_id")
    @Getter @Setter
    Album album;

    @OneToMany(mappedBy = "track")
    private Set<Voto> votos = new HashSet<>();

}
