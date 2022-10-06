package com.alkemy.challengebackend.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String  imagen;
    private List<PeliculaOSerieDto> peliculaOSeries;
}
