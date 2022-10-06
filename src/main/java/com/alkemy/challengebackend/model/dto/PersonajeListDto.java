package com.alkemy.challengebackend.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeListDto {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String imagen;
    private String nombre;
}
