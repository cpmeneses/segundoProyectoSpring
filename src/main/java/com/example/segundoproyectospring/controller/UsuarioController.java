package com.example.segundoproyectospring.controller;

import com.example.segundoproyectospring.entity.Usuario;
import com.example.segundoproyectospring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuarios", listaUsuarios);
        return "templateListarUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario() {
        return "templateFormularioCrearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/usuario";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(Model model,
                                @PathVariable("id") int id){
        Usuario usuario = objUsuarioService.listarUsuarioId(id);
        model.addAttribute("usuario",usuario);
        return "templateFormularioModificarUsuario";
    }


    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute Usuario datosParaActualizar){

        Usuario usuario = objUsuarioService.listarUsuarioId(datosParaActualizar.getId());
        usuario.setNombreUsuario(datosParaActualizar.getNombreUsuario());
        usuario.setRol(datosParaActualizar.getRol());
        usuario.setContrasena(datosParaActualizar.getContrasena());
        objUsuarioService.actualizarUsuario(usuario);

        return "redirect:/usuario";
    }
}
