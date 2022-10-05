package com.alkemy.challengebackend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "personajes")
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String imagen;
    @Column
    private String nombre;
    @Column
    private Integer edad;
    @Column
    private double peso;
    @Column(length = 500)
    private String historia;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "personaje_peliculaOSerie", joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "peliculaOSerie_id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = {"personaje_id", "peliculaOSerie_id"})})
    private List<PeliculaOSerie> peliculasOSeries;
}
