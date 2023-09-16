package com.example.segundoproyectospring.service.serviceImpl;

import com.example.segundoproyectospring.entity.Curso;
import com.example.segundoproyectospring.repository.ICursoRepository;
import com.example.segundoproyectospring.service.IProfesorService;
import com.example.segundoproyectospring.entity.Profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segundoproyectospring.repository.IProfesorRepository;

import java.util.ArrayList;
import java.util.List;

@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    IProfesorRepository objProfesorRepo;

    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        Profesor nuevoProfesor = new Profesor();
        List<Curso> cursosAsignados = new ArrayList<>();

        for (Curso curso : profesorCreado.getListaCursos()) {
            Curso cursoAsignado = objCursoRepo.findById(curso.getId()).orElse(null);
            cursosAsignados.add(cursoAsignado);
        }

        nuevoProfesor.setNombre(profesorCreado.getNombre());
        nuevoProfesor.setApellido1(profesorCreado.getApellido1());
        nuevoProfesor.setApellido2(profesorCreado.getApellido2());
        nuevoProfesor.setListaCursos(cursosAsignados);

        nuevoProfesor = objProfesorRepo.save(nuevoProfesor);
        return nuevoProfesor;
    }

    @Override
    public List<Profesor> listarProfesores() {
        List<Profesor> listaAMostrar = new ArrayList<Profesor>();
        listaAMostrar = objProfesorRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public Profesor listarProfesorId(int id) {
        Profesor profesorListado = new Profesor();
        profesorListado = objProfesorRepo.getReferenceById(id);
        return profesorListado;
    }

    @Override
    public Profesor actualizarProfesor(int id, Profesor profesor) {
        Profesor profesorEncontrado = objProfesorRepo.findById(id).orElse(null);
        profesorEncontrado.setNombre(profesor.getNombre());
        profesorEncontrado.setApellido1(profesor.getApellido1());
        profesorEncontrado.setApellido2(profesor.getApellido2());
        profesorEncontrado.setListaCursos(profesor.getListaCursos());
        return objProfesorRepo.save(profesorEncontrado);
    }

    @Override
    public void eliminarProfesor(int id) {
        objProfesorRepo.deleteById(id);
    }
}
