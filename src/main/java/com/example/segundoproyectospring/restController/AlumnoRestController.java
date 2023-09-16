package com.example.segundoproyectospring.restController;

import com.example.segundoproyectospring.entity.Alumno;
import com.example.segundoproyectospring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {

    @Autowired
    IAlumnoService objAlumnoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return objAlumnoService.crearAlumno(alumno);
    }

    @GetMapping
    public List<Alumno> listarAlumnos() {
        return objAlumnoService.listarAlumnos();
    }

    @GetMapping("/{id}")
    public Alumno listarAlumnosId(@PathVariable int id) {
        return objAlumnoService.listarAlumnoId(id);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno) {
        return objAlumnoService.actualizarAlumno(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable int id) {
        objAlumnoService.eliminarAlumno(id);
    }
}
