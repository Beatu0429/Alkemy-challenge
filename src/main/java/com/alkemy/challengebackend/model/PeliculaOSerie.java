package com.alkemy.challengebackend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "peliculasOSeries")
@NoArgsConstructor
public class PeliculaOSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String imagen;
    @Column
    private String titulo;
    @Column
    private LocalDate fechaCreacion;
    @Column(length = 5)
    private Integer calificacion;
    @JsonBackReference
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    private Genero genero;
    @JsonBackReference
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handle"}, allowSetters = true)
    @ManyToMany(mappedBy = "peliculasOSeries", fetch = FetchType.LAZY)
    private List<Personaje> personajes;

}
