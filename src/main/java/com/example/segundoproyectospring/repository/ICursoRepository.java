package com.example.segundoproyectospring.repository;

import com.example.segundoproyectospring.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
