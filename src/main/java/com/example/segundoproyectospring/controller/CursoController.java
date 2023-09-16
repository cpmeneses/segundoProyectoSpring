package com.example.segundoproyectospring.controller;

import com.example.segundoproyectospring.entity.Curso;
import com.example.segundoproyectospring.entity.Usuario;
import com.example.segundoproyectospring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("atributoListaCursos", listaCursos);
        return "templateListarCursos";
    }

    @GetMapping("/crearCurso")
    public String mostrarFormularioCrearCurso(){
        return "templateFormularioCrearCurso";
    }

    @PostMapping("/crearCurso")
    public String crearCurso(@ModelAttribute Curso curso) {
        objCursoService.crearCurso(curso);
        return "redirect:/curso";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id) {
        objCursoService.eliminarCurso(id);
        return "redirect:/curso";
    }

    @GetMapping("/editar/{id}")
    public String editarCurso(Model model,
                                @PathVariable("id") int id){
        Curso curso = objCursoService.listarCursoId(id);
        model.addAttribute("curso", curso);
        return "templateFormularioModificarCurso";
    }


    @PostMapping("/editar")
    public String editarCurso(@ModelAttribute Curso datosParaActualizar){

        Curso curso = objCursoService.listarCursoId(datosParaActualizar.getId());
        curso.setNombreCurso(datosParaActualizar.getNombreCurso());
        curso.setListaProfesores(datosParaActualizar.getListaProfesores());
        curso.setListaAlumnos(datosParaActualizar.getListaAlumnos());
        objCursoService.actualizarCurso(curso.getId(), curso);

        return "redirect:/curso";
    }
}
