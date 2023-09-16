package com.example.segundoproyectospring.controller;

import com.example.segundoproyectospring.entity.Curso;
import com.example.segundoproyectospring.entity.Profesor;
import com.example.segundoproyectospring.entity.Usuario;
import com.example.segundoproyectospring.service.ICursoService;
import com.example.segundoproyectospring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;

    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarProfesores(Model model) {
        List<Profesor> listaProfesores = objProfesorService.listarProfesores();
        model.addAttribute("atributoListaProfesores", listaProfesores);
        return "templateListarProfesores";
    }

    @GetMapping("/crearProfesor")
    public String mostrarFormularioCrearProfesor(Model model) {
        List<Curso> cursos = objCursoService.listarCursos();
        model.addAttribute("atributoListarCursos", cursos);
        return "templateFormularioCrearProfesor";
    }

    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor) {
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id) {
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }

    @GetMapping("/editar/{id}")
    public String editarProfesor(Model model,
                                @PathVariable("id") int id){
        Profesor profesor = objProfesorService.listarProfesorId(id);
        model.addAttribute("profesor", profesor);
        List<Curso> cursos = objCursoService.listarCursos();
        model.addAttribute("atributoListarCursos", cursos);
        return "templateFormularioModificarProfesor";
    }

    @PostMapping("/editar")
    public String editarProfesor(@ModelAttribute Profesor datosParaActualizar){

        Profesor profesor = objProfesorService.listarProfesorId(datosParaActualizar.getId());
        profesor.setNombre(datosParaActualizar.getNombre());
        profesor.setApellido1(datosParaActualizar.getApellido1());
        profesor.setApellido2(datosParaActualizar.getApellido2());
        profesor.setListaCursos(datosParaActualizar.getListaCursos());
        objProfesorService.actualizarProfesor(profesor.getId(), profesor);

        return "redirect:/profesor";
    }
}
