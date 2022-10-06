package com.alkemy.challengebackend.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private double peso;
    private String historia;
    private List<PeliculaOSerieDto> peliculasOSeries;
}
