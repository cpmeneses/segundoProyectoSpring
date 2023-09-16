package com.example.segundoproyectospring.repository;

import com.example.segundoproyectospring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
