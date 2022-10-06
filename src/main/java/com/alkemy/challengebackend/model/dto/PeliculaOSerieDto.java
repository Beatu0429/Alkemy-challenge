package com.alkemy.challengebackend.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaOSerieDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private Integer calificacion;
    private List<PersonajeListDto> personajes;
}
