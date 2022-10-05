package com.alkemy.challengebackend.model.dto;

import java.time.LocalDate;
import java.util.List;

public class PeliculaOSerieDto {
    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private Integer calificacion;
    private List<PersonajeDto> personajes;

}
