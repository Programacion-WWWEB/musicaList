package com.example.musicalist.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class RecomendacionId implements Serializable{
    
    @Getter @Setter
    private Long idgenero;

    @Getter @Setter
    private Long albumId;

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecomendacionId recomendacionId = (RecomendacionId) o;
        return Objects.equals(idgenero, recomendacionId.idgenero) &&
               Objects.equals(albumId, recomendacionId.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgenero, albumId);
    }
    
}
