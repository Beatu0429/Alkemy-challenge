package com.alkemy.challengebackend.service.impl;

import com.alkemy.challengebackend.model.PeliculaOSerie;
import com.alkemy.challengebackend.model.dto.PeliculaOSerieDto;
import com.alkemy.challengebackend.model.dto.PeliculaOSerieListDto;
import com.alkemy.challengebackend.repository.IPeliculaOSerieRepository;
import com.alkemy.challengebackend.service.IPeliculaOSerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeliculaOSerieServiceImpl implements IPeliculaOSerieService {

    @Autowired
    private IPeliculaOSerieRepository peliculaRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public PeliculaOSerieDto createPeliculaOSerie(PeliculaOSerieDto peliculaOSerieDto) {
        PeliculaOSerie pelicula = mapper.map(peliculaOSerieDto, PeliculaOSerie.class);
        pelicula = peliculaRepository.save(pelicula);
        if (pelicula != null){
            PeliculaOSerieDto peliculaSaved = mapper.map(pelicula, PeliculaOSerieDto.class);
            return peliculaSaved;
        }
        return null;
    }

    @Override
    public PeliculaOSerieDto readPeliculaOSerie(Long id) {
        PeliculaOSerieDto peliculaDto = null;
        if (peliculaRepository.findById(id).isPresent()){
            Optional<PeliculaOSerie> pelicula = peliculaRepository.findById(id);
            peliculaDto = mapper.map(pelicula.get(), PeliculaOSerieDto.class);
        }
        return peliculaDto;
    }

    @Override
    public PeliculaOSerieDto updatePeliculaOSerie(PeliculaOSerieDto peliculaOSerieDto) {
        if (peliculaOSerieDto.getId()!=null){
            PeliculaOSerie pelicula = mapper.map(peliculaOSerieDto, PeliculaOSerie.class);
            pelicula = peliculaRepository.save(pelicula);
            if (pelicula != null){
                PeliculaOSerieDto peliculaSaved = mapper.map(pelicula, PeliculaOSerieDto.class);
                return peliculaSaved;
            }
        }
        return null;
    }

    @Override
    public void deletePeliculaOSerie(Long id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<PeliculaOSerieListDto> listPeliculaOSerie(String name,
                                                          Long genreId,
                                                          String order) {
        List<PeliculaOSerie> peliculas = new ArrayList<>();
        if(name == null && genreId == null && order == null){
            peliculas = peliculaRepository.findAll();
        } else if (name != null){
            peliculas = peliculaRepository.findByTitulo(name);
        } else if (genreId != null){
            peliculas = peliculaRepository.getByGenero(genreId);
        } else if (order != null){
            if (order.equals("ASC")){
                peliculas =peliculaRepository.getAllOrderByFechaCreacionAsc();
            }
            if (order.equals("DESC")){
                peliculas = peliculaRepository.getAllOrderByFechaCreacionDesc();
            }
        }

        List<PeliculaOSerieListDto> listPeliculas = new ArrayList<>();

        for (PeliculaOSerie pelicula : peliculas) {
            listPeliculas.add(mapper.map(pelicula, PeliculaOSerieListDto.class));
        }

        return listPeliculas;
    }
}
