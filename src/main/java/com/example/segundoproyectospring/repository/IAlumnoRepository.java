package com.example.segundoproyectospring.repository;

import com.example.segundoproyectospring.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

}
