package com.example.segundoproyectospring.service;

import com.example.segundoproyectospring.entity.Profesor;

import java.util.List;

public interface IProfesorService {
    public Profesor crearProfesor(Profesor profesorACrear);
    public List<Profesor> listarProfesores();
    public Profesor listarProfesorId(int id);
    public Profesor actualizarProfesor(int id, Profesor profesor);
    public void eliminarProfesor(int id);
}