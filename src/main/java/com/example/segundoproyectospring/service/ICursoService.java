package com.example.segundoproyectospring.service;

import com.example.segundoproyectospring.entity.Curso;

import java.util.List;

public interface ICursoService {
    public Curso crearCurso(Curso cursoACrear);
    public List<Curso> listarCursos();
    public Curso listarCursoId(int id);
    public Curso actualizarCurso(int id, Curso curso);
    public void eliminarCurso(int id);
}