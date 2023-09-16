package com.example.segundoproyectospring.service;

import com.example.segundoproyectospring.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario usuarioACrear);
    public List<Usuario> crearUsuarios(List<Usuario> usuariosACrear);
    public List<Usuario> listarUsuario();
    public Usuario listarUsuarioId(int id);
    public Usuario actualizarUsuario(int id, Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(int id);
}
