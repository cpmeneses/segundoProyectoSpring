package com.example.segundoproyectospring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 1)
    private String nombreCurso;

    @ManyToMany(mappedBy = "listaCursos", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Profesor> listaProfesores;

    @OneToMany(mappedBy = "cursoAsignado", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Alumno> listaAlumnos;
}
