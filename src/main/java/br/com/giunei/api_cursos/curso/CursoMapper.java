package br.com.giunei.api_cursos.curso;

import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoDto toCursoDto(Curso curso) {
        return CursoDto.builder()
                .id(curso.getId())
                .name(curso.getName())
                .category(curso.getCategory())
                .active(curso.getActive())
                .build();
    }

    public Curso toCursoEntity(CursoDto cursoDto) {
        return Curso.builder()
                .id(cursoDto.getId())
                .name(cursoDto.getName())
                .category(cursoDto.getCategory())
                .active(cursoDto.getActive())
                .build();
    }
}
