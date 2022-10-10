package com.alkemy.challengebackend.repository;

import com.alkemy.challengebackend.model.PeliculaOSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPeliculaOSerieRepository extends JpaRepository<PeliculaOSerie, Long> {

    public List<PeliculaOSerie> findByTitulo(String titulo);

    @Query(value = "select * from peliculasOSeries where genero_id = :id",
            nativeQuery = true)
    public List<PeliculaOSerie> getByGenero(Long id);

    @Query(value = "select * from peliculasOSeries order by fecha_creacion",
    nativeQuery = true)
    public List<PeliculaOSerie> getAllOrderByFechaCreacionAsc();

    @Query(value = "select * from peliculasOSeries order by fecha_creacion desc",
            nativeQuery = true)
    public List<PeliculaOSerie> getAllOrderByFechaCreacionDesc();

}
