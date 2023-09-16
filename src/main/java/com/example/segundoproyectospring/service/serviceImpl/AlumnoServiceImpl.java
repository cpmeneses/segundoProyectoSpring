package com.example.segundoproyectospring.service.serviceImpl;

import com.example.segundoproyectospring.entity.Alumno;

import com.example.segundoproyectospring.entity.Curso;
import com.example.segundoproyectospring.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segundoproyectospring.repository.IAlumnoRepository;
import com.example.segundoproyectospring.service.IAlumnoService;

import java.util.ArrayList;
import java.util.List;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    IAlumnoRepository objAlumnoRepo;

    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Alumno crearAlumno(Alumno alumnoCreado) {
        Alumno nuevoAlumno = new Alumno();
        Curso cursoAsignado = new Curso();
        cursoAsignado = objCursoRepo.findById(alumnoCreado.getCursoAsignado().getId()).orElse(null);
        alumnoCreado.setCursoAsignado(cursoAsignado);
        nuevoAlumno = objAlumnoRepo.save(alumnoCreado);
        return nuevoAlumno;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        List<Alumno> listaAMostrar = new ArrayList<Alumno>();
        listaAMostrar = objAlumnoRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public Alumno listarAlumnoId(int id) {
        Alumno alumno = new Alumno();
        alumno = objAlumnoRepo.getReferenceById(id);
        return alumno;
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumno) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(id).orElse(null);
        alumnoEncontrado.setNombres(alumno.getNombres());
        alumnoEncontrado.setApellido1(alumno.getApellido1());
        alumnoEncontrado.setApellido2(alumno.getApellido2());
        alumnoEncontrado.setCursoAsignado(alumno.getCursoAsignado());
        return objAlumnoRepo.save(alumnoEncontrado);
    }

    @Override
    public void eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id);
    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
        objAlumnoRepo.delete(alumno);
    }
}
