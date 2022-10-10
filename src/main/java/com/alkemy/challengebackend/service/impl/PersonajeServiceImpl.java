package com.alkemy.challengebackend.service.impl;

import com.alkemy.challengebackend.model.Personaje;
import com.alkemy.challengebackend.model.dto.PersonajeDto;
import com.alkemy.challengebackend.model.dto.PersonajeListDto;
import com.alkemy.challengebackend.repository.IPersonajeRepository;
import com.alkemy.challengebackend.service.IPersonajeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private IPersonajeRepository personajeRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public PersonajeDto createPersonaje(PersonajeDto personajeDto) {
        Personaje personaje = mapper.map(personajeDto, Personaje.class);
        personaje = personajeRepository.save(personaje);
        if (personaje != null){
            PersonajeDto personajeDto1 = mapper.map(personaje, PersonajeDto.class);
            return personajeDto1;
        }
        return null;
    }

    @Override
    public PersonajeDto readPersonaje(Long id) {
        PersonajeDto personajeDto = null;
        if(personajeRepository.findById(id).isPresent()){
            Optional<Personaje> personaje = personajeRepository.findById(id);
            personajeDto = mapper.map(personaje.get(), PersonajeDto.class);
        }

        return personajeDto;
    }

    @Override
    public PersonajeDto updatePersonaje(PersonajeDto personajeDto) {
        if (personajeDto.getId() != null){
            Personaje personaje = mapper.map(personajeDto, Personaje.class);
            personaje = personajeRepository.save(personaje);
            if (personaje != null){
                PersonajeDto personajeDto1 = mapper.map(personaje, PersonajeDto.class);
                return personajeDto1;
            }
        }
        return null;
    }

    @Override
    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }

    @Override
    public List<PersonajeListDto> listPersonaje() {
        List<Personaje> personajes = personajeRepository.findAll();
        List<PersonajeListDto> personajeListDtos = new ArrayList<>();

        for (Personaje personaje : personajes) {
            personajeListDtos.add(mapper.map(personaje, PersonajeListDto.class));
        }
        return personajeListDtos;
    }

    @Override
    public List<PersonajeListDto> filtrarPersonajes(String nombre, Integer edad,
                                                    Double peso, Long id) {
        List<Personaje> personajes = new ArrayList<>();
        if(nombre != null){
            personajes = personajeRepository.findByNombre(nombre);
        }
        if (edad != null){
            personajes = personajeRepository.findByEdad(edad);
        }
        if (peso != null){
            personajes = personajeRepository.findByPeso(peso);
        }
        if (id != null){
            personajes = personajeRepository.findByPeliculasOSeries(id);
        }

        List<PersonajeListDto> personajeListDtos = new ArrayList<>();

        for (Personaje personaje : personajes) {
            personajeListDtos.add(mapper.map(personaje, PersonajeListDto.class));
        }
        return personajeListDtos;
    }
}
