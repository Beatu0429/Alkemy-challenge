package com.alkemy.challengebackend.service;

import com.alkemy.challengebackend.model.dto.PersonajeDto;
import com.alkemy.challengebackend.model.dto.PersonajeListDto;

import java.util.List;

public interface IPersonajeService {

    public PersonajeDto createPersonaje(PersonajeDto personajeDto);

    public PersonajeDto readPersonaje(Long id);

    public PersonajeDto updatePersonaje(PersonajeDto personajeDto);

    public void deletePersonaje(Long id);

    public List<PersonajeListDto> listPersonaje();

    public List<PersonajeListDto> filtrarPersonajes(String nombre, Integer edad,
                                                    Double peso, Long id);

}
