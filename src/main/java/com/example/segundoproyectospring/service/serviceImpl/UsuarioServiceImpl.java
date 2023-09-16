package com.example.segundoproyectospring.service.serviceImpl;

import com.example.segundoproyectospring.entity.Usuario;
import com.example.segundoproyectospring.repository.IUsuarioRepository;
import com.example.segundoproyectospring.service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuarioCreado) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario = objUsuarioRepo.save(usuarioCreado);
        return nuevoUsuario;
    }

    @Override
    public List<Usuario> crearUsuarios(List<Usuario> usuariosACrear) {
        List<Usuario> nuevosUsuarios = new ArrayList<Usuario>();
        nuevosUsuarios = objUsuarioRepo.saveAll(usuariosACrear);
        return nuevosUsuarios;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listaAMostrar = new ArrayList<Usuario>();
        listaAMostrar = objUsuarioRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public Usuario listarUsuarioId(int id) {
        Usuario usuarioListado = new Usuario();
        usuarioListado = objUsuarioRepo.getReferenceById(id);
        return usuarioListado;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = objUsuarioRepo.findById(usuario.getId()).orElse(null);
        usuarioEncontrado.setNombreUsuario(usuario.getNombreUsuario());
        usuarioEncontrado.setRol(usuario.getRol());
        usuarioEncontrado.setContrasena(usuario.getContrasena());
        return objUsuarioRepo.save(usuarioEncontrado);
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuario) {
        Usuario usuarioEncontrado = objUsuarioRepo.findById(id).orElse(null);
        usuarioEncontrado.setNombreUsuario(usuario.getNombreUsuario());
        usuarioEncontrado.setRol(usuario.getRol());
        usuarioEncontrado.setContrasena(usuario.getContrasena());
        return objUsuarioRepo.save(usuarioEncontrado);
    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }
}
