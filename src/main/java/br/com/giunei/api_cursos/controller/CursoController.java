package br.com.giunei.api_cursos.controller;

import br.com.giunei.api_cursos.curso.CursoDto;
import br.com.giunei.api_cursos.curso.CursoMapper;
import br.com.giunei.api_cursos.curso.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoMapper cursoMapper;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody CursoDto curso) {
        CursoDto result = cursoMapper.toCursoDto(
                cursoService.save(
                        cursoMapper.toCursoEntity(curso)));
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public List<CursoDto> listAllCursos() {
        return cursoService.listAllCursos().stream().map(cursoMapper::toCursoDto).toList();
    }

    @PutMapping("/{id}")
    public CursoDto update(@PathVariable UUID id,
                           @Valid @RequestBody CursoDto curso) {
        curso.setId(id);
        return cursoMapper.toCursoDto(
                cursoService.update(
                        cursoMapper.toCursoEntity(curso)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        cursoService.delete(id);
    }
}
