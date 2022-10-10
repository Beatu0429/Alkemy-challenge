package com.alkemy.challengebackend.repository;

import com.alkemy.challengebackend.model.PeliculaOSerie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPeliculaOSerieRepository {

    public List<PeliculaOSerie> findByTitulo(String titulo);

    public List<PeliculaOSerie> findByGenero(Long id);

}
