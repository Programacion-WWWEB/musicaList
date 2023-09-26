package com.example.musicalist.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class VotoId implements Serializable{

    @Getter @Setter

    private Long id;
    @Getter @Setter
    private Long track_id; 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotoId votoId = (VotoId) o;
        return Objects.equals(id, votoId.id) &&
               Objects.equals(track_id, votoId.track_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, track_id);
    }
    
}
