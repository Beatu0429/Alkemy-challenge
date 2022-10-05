package com.alkemy.challengebackend.service;

import com.alkemy.challengebackend.model.dto.PersonajeDto;
import com.alkemy.challengebackend.model.dto.PersonajeListDto;

import java.util.List;

public interface IPersonajeService {

    public PersonajeDto createPersonaje(PersonajeDto personajeDto);

    public PersonajeDto readePersonaje(Long id);

    public PersonajeDto updatePersonaje(PersonajeDto personajeDto);

    public void deletePersonaje(Long id);

    public List<PersonajeListDto> listPersonaje();

}
