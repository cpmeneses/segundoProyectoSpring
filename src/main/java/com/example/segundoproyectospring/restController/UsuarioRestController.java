package com.example.segundoproyectospring.restController;

import com.example.segundoproyectospring.entity.Usuario;
import com.example.segundoproyectospring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return objUsuarioService.crearUsuario(usuario);
    }

    @PostMapping("/list")
    public List<Usuario> crearUsuarios(@RequestBody List<Usuario> usuarios) {
        return objUsuarioService.crearUsuarios(usuarios);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return objUsuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuariosId(@PathVariable int id) {
        return objUsuarioService.listarUsuarioId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return objUsuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        objUsuarioService.eliminarUsuario(id);
    }
}
