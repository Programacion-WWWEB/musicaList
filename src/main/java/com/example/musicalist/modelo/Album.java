package com.example.musicalist.modelo;

import javax.persistence.Entity;

import org.apache.commons.lang3.time.DateFormatUtils;

@Entity
public class Album {

    private String name;

    private String artist;

    private String type;

    private DateFormatUtils release_date;

    
    
}
