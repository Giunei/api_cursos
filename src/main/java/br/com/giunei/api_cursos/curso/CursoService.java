package br.com.giunei.api_cursos.curso;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CursoService {

    Curso save(Curso curso);
    Curso update(Curso curso);

    List<Curso> listAllCursos();

    void delete(UUID id);
}
