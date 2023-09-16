package com.example.segundoproyectospring.service;

import com.example.segundoproyectospring.entity.Alumno;

import java.util.List;

public interface IAlumnoService {
    public Alumno crearAlumno(Alumno alumnoACrear);
    public List<Alumno> listarAlumnos();
    public Alumno listarAlumnoId(int id);
    public Alumno actualizarAlumno(int id, Alumno alumno);
    public void eliminarAlumno(int id);
    public void eliminarAlumno(Alumno alumno);
}
