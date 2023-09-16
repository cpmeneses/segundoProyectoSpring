package com.example.segundoproyectospring.repository;

import com.example.segundoproyectospring.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {
}
