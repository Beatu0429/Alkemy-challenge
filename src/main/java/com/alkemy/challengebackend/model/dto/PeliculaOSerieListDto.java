package com.alkemy.challengebackend.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaOSerieListDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
}
