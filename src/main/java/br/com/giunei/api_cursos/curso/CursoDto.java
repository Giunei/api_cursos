package br.com.giunei.api_cursos.curso;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
public class CursoDto {

    private UUID id;
    private String name;
    private String category;
    private Status active;
}
