package com.alkemy.challengebackend.controller;

import com.alkemy.challengebackend.model.dto.PersonajeDto;
import com.alkemy.challengebackend.model.dto.PersonajeListDto;
import com.alkemy.challengebackend.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
public class PersonajesController {

    @Autowired
    private IPersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDto> createCharacter(@RequestBody PersonajeDto personajeDto){
        return new ResponseEntity(personajeService.createPersonaje(personajeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDto> readCharacter(@PathVariable Long id){
        return new ResponseEntity(personajeService.readPersonaje(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PersonajeDto> updateCharacter(@RequestBody PersonajeDto personajeDto){
        return new ResponseEntity(personajeService.updatePersonaje(personajeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id){
        personajeService.deletePersonaje(id);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeListDto>> listCharactersByFilter(@RequestParam(required = false) String name,
                                                                         @RequestParam(required = false) Integer age,
                                                                         @RequestParam(required = false) Double weight,
                                                                         @RequestParam(required = false) Long moviesId){
        if(name == null && age==null && weight==null && moviesId==null){
            return new ResponseEntity(personajeService.listPersonaje(), HttpStatus.OK);
        }

        return new ResponseEntity(personajeService.filtrarPersonajes(name, age, weight, moviesId), HttpStatus.OK);

    }



}

