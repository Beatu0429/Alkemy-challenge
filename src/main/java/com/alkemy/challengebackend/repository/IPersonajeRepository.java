package com.alkemy.challengebackend.repository;

import com.alkemy.challengebackend.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Long> {
}
