package com.example.musicalist.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class RecomendacionId implements Serializable{
    
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long album_id;

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecomendacionId recomendacionId = (RecomendacionId) o;
        return Objects.equals(id, recomendacionId.id) &&
               Objects.equals(album_id, recomendacionId.album_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, album_id);
    }
    
}
