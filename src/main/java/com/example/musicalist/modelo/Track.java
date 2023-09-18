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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(exclude = "trackId")
public class Track {
     

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Long trackId;
     
    @Getter @Setter
    private String title;

    @Getter @Setter
    private Time duration;

    @ManyToOne()
    @JoinColumn(name = "albumId")
    Album album;

    @OneToMany(mappedBy = "track")
    private Set<Voto> votos = new HashSet<>();

}
