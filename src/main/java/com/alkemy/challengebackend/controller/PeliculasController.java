package com.alkemy.challengebackend.controller;

import com.alkemy.challengebackend.model.dto.PeliculaOSerieDto;
import com.alkemy.challengebackend.model.dto.PeliculaOSerieListDto;
import com.alkemy.challengebackend.model.dto.PersonajeDto;
import com.alkemy.challengebackend.model.dto.PersonajeListDto;
import com.alkemy.challengebackend.service.IPeliculaOSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class PeliculasController {

    @Autowired
    private IPeliculaOSerieService peliculaOSerieService;

    @PostMapping
    public ResponseEntity<PeliculaOSerieDto> createMovie(@RequestBody PeliculaOSerieDto peliculaOSerieDto){
        return new ResponseEntity(peliculaOSerieService.createPeliculaOSerie(peliculaOSerieDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaOSerieDto> readMovie(@PathVariable Long id){
        return new ResponseEntity(peliculaOSerieService.readPeliculaOSerie(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PeliculaOSerieDto> updateMovie(@RequestBody PeliculaOSerieDto peliculaOSerieDto){
        return new ResponseEntity(peliculaOSerieService.updatePeliculaOSerie(peliculaOSerieDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        peliculaOSerieService.deletePeliculaOSerie(id);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaOSerieListDto>> listCharactersByFilter(@RequestParam(required = false) String name,
                                                                              @RequestParam(required = false) Long genreId,
                                                                              @RequestParam(required = false) String order){
        return new ResponseEntity(peliculaOSerieService.listPeliculaOSerie(name, genreId, order), HttpStatus.OK);

    }
}
