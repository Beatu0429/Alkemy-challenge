package com.alkemy.challengebackend.service;

import com.alkemy.challengebackend.model.dto.PeliculaOSerieDto;
import com.alkemy.challengebackend.model.dto.PeliculaOSerieListDto;

import java.util.List;

public interface IPeliculaOSerieService {

    public PeliculaOSerieDto createPeliculaOSerie(PeliculaOSerieDto peliculaOSerieDto);

    public PeliculaOSerieDto readPeliculaOSerie(Long id);

    public PeliculaOSerieDto updatePeliculaOSerie(PeliculaOSerieDto peliculaOSerieDto);

    public void deletePeliculaOSerie(Long id);

    public List<PeliculaOSerieListDto> listPeliculaOSerie();

}
