package br.com.giunei.api_cursos.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {

}
