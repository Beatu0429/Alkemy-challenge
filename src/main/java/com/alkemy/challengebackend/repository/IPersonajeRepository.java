package com.alkemy.challengebackend.repository;

import com.alkemy.challengebackend.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Long> {

    public List<Personaje> findByNombre(String nombre);

}
