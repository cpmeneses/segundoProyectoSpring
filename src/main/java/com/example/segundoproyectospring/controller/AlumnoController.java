package com.example.segundoproyectospring.controller;

import com.example.segundoproyectospring.entity.Alumno;
import com.example.segundoproyectospring.entity.Curso;
import com.example.segundoproyectospring.entity.Usuario;
import com.example.segundoproyectospring.service.IAlumnoService;
import com.example.segundoproyectospring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    IAlumnoService objAlumnoService;

    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarAlumnos(Model model) {
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumnos();
        model.addAttribute("atributoListaAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }

    @GetMapping("/crearAlumno")
    public String mostrarFormularioCrearAlumno(Model model){
        List<Curso> cursos = objCursoService.listarCursos();
        model.addAttribute("atributoListarCursos", cursos);
        return "templateFormularioCrearAlumno";
    }

    @PostMapping("/crearAlumno")
    public String crearAlumno(@ModelAttribute Alumno alumno, @RequestParam("cursoId") int cursoId) {
        Curso curso = objCursoService.listarCursoId(cursoId);
        alumno.setCursoAsignado(curso);
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id) {
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno";
    }

    @GetMapping("/editar/{id}")
    public String editarAlumno(Model model,
                                @PathVariable("id") int id){
        Alumno alumno = objAlumnoService.listarAlumnoId(id);
        model.addAttribute("alumno", alumno);
        List<Curso> cursos = objCursoService.listarCursos();
        model.addAttribute("atributoListarCursos", cursos);
        return "templateFormularioModificarAlumno";
    }


    @PostMapping("/editar")
    public String editarAlumno(@ModelAttribute Alumno datosParaActualizar){

        Alumno alumno = objAlumnoService.listarAlumnoId(datosParaActualizar.getId());
        alumno.setNombres(datosParaActualizar.getNombres());
        alumno.setApellido1(datosParaActualizar.getApellido1());
        alumno.setApellido2(datosParaActualizar.getApellido2());
        alumno.setCursoAsignado(datosParaActualizar.getCursoAsignado());
        objAlumnoService.actualizarAlumno(alumno.getId(), alumno);

        return "redirect:/alumno";
    }
}
