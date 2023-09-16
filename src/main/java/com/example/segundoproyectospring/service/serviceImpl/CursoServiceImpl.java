package com.example.segundoproyectospring.service.serviceImpl;

import com.example.segundoproyectospring.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segundoproyectospring.repository.ICursoRepository;
import com.example.segundoproyectospring.service.ICursoService;

import java.util.ArrayList;
import java.util.List;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {
    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Curso crearCurso(Curso cursoCreado) {
        Curso nuevoCurso = new Curso();
        nuevoCurso = objCursoRepo.save(cursoCreado);
        return nuevoCurso;
    }

    @Override
    public List<Curso> listarCursos() {
        List<Curso> listaAMostrar = new ArrayList<Curso>();
        listaAMostrar = objCursoRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public Curso listarCursoId(int id) {
        Curso cursoListado = new Curso();
        cursoListado = objCursoRepo.getReferenceById(id);
        return cursoListado;
    }

    @Override
    public Curso actualizarCurso(int id, Curso curso) {
        Curso cursoEncontrado = objCursoRepo.findById(id).orElse(null);
        cursoEncontrado.setNombreCurso(curso.getNombreCurso());
        cursoEncontrado.setListaAlumnos(curso.getListaAlumnos());
        cursoEncontrado.setListaProfesores(curso.getListaProfesores());
        return objCursoRepo.save(cursoEncontrado);
    }

    @Override
    public void eliminarCurso(int id) {
        objCursoRepo.deleteById(id);
    }
}
