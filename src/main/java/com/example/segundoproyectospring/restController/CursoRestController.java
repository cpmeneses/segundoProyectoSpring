package com.example.segundoproyectospring.restController;

import com.example.segundoproyectospring.entity.Curso;
import com.example.segundoproyectospring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {

    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso){
        return objCursoService.crearCurso(curso);
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return objCursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso listarCursosId(@PathVariable int id) {
        return objCursoService.listarCursoId(id);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso curso){
        return objCursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id) {
        objCursoService.eliminarCurso(id);
    }
}
