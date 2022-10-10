package com.alkemy.challengebackend.repository;

import com.alkemy.challengebackend.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Long> {

    public List<Personaje> findByNombre(String nombre);

    public List<Personaje> findByEdad(Integer edad);

    public List<Personaje> findByPeso(Double peso);

    @Query(value = "select * from personajes inner join personaje_peliculaoserie " +
            "on personajes.id=personaje_peliculaoserie.personaje_id where" +
            " personaje_peliculaoserie.peliculaoserie_id = :id", nativeQuery = true)
    public List<Personaje> findByPeliculasOSeries(Long id);

}
