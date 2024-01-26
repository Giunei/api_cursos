package br.com.giunei.api_cursos.curso;

import br.com.giunei.api_cursos.exceptions.CursoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository repo;

    @Override
    public Curso save(Curso curso) {
        return repo.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        if (cursoExists(curso.getId())) {
            throw new CursoNotFoundException(curso.getId());
        }
        return save(curso);
    }

    @Override
    public List<Curso> listAllCursos() {
        return repo.findAll();
    }

    @Override
    public void delete(UUID id) {
        if (cursoExists(id)) {
            throw new CursoNotFoundException(id);
        }
        repo.deleteById(id);
    }

    private boolean cursoExists(UUID id) {
        return !repo.existsById(id);
    }
}
