package DIO.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DIO.springboot.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,  Integer> {

}

