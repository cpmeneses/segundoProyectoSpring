package com.example.segundoproyectospring.restController;

import com.example.segundoproyectospring.entity.Profesor;
import com.example.segundoproyectospring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorRestController {
    @Autowired
    IProfesorService objProfesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return objProfesorService.crearProfesor(profesor);
    }

    @GetMapping
    public List<Profesor> listarProfesores() {
        return objProfesorService.listarProfesores();
    }

    @GetMapping("/{id}")
    public Profesor listarProfesorId(@PathVariable int id) {
        return objProfesorService.listarProfesorId(id);
    }

    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable int id, @RequestBody Profesor profesor) {
        return objProfesorService.actualizarProfesor(id, profesor);
    }

    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable int id) {
        objProfesorService.eliminarProfesor(id);
    }

}
