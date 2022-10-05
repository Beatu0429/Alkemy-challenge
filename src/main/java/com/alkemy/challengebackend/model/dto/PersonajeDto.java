package com.alkemy.challengebackend.model.dto;

import java.util.List;

public class PersonajeDto {
    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private double peso;
    private String historia;
    private List<PeliculaOSerieDto> peliculaOSeries;
}
