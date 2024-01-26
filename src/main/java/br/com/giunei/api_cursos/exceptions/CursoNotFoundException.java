package br.com.giunei.api_cursos.exceptions;

import java.util.UUID;

public class CursoNotFoundException extends RuntimeException{

    public CursoNotFoundException(UUID id) {
        super("Curso not found by: " + id);
    }
}
