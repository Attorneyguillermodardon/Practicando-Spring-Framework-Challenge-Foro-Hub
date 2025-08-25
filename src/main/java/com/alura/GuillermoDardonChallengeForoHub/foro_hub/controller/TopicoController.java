package com.alura.GuillermoDardonChallengeForoHub.foro_hub.controller;

import com.alura.GuillermoDardonChallengeForoHub.foro_hub.Validations.ValidadorTituloDuplicado;
import com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.topico.*;
import com.alura.GuillermoDardonChallengeForoHub.foro_hub.repository.TopicoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    ValidadorTituloDuplicado validadorTituloDuplicado;

    @Transactional
    @PostMapping

    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datos);
        validadorTituloDuplicado.validar(topico.getTitulo());
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }
    //  Mapping normal (http://localhost:8080/api/topicos):
    //@GetMapping
    //public Page<DatosListaTopico> listar(@PageableDefault(page = 0, size = 10, sort = "fecha", direction = Sort.Direction.ASC)Pageable paginacion){
    //return repository.findAll(paginacion).map(DatosListaTopico::new);
    //}

    //Mapping para buscar por año y curso (ej: http://localhost:8080/api/topicos?curso=Fundamentos%20del%20Legal%20tech&anio=2025):
    @GetMapping
    public Page<DatosListaTopico> listar(

            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer anio,
            @PageableDefault(page = 0, size = 10, sort = "fecha", direction = Sort.Direction.ASC) Pageable paginacion) {

        if (curso != null && anio != null) {
            LocalDateTime inicio = LocalDateTime.of(anio, 1, 1, 0, 0);
            LocalDateTime fin = LocalDateTime.of(anio, 12, 31, 23, 59);
            return repository.findByCursoAndFechaBetween(curso, inicio, fin, paginacion).map(DatosListaTopico::new);
        }

        return repository.findAll(paginacion).map(DatosListaTopico::new);

    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var topico = repository.findById(id);

        if (topico.isPresent()) {
            Topico t = topico.get();
            t.setTitulo(datos.titulo());
            t.setMensaje(datos.mensaje());
            t.setAutor(datos.autor());
            t.setCurso(datos.curso());
            return ResponseEntity.ok(new DatosDetalleTopico(t));
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DatosDetalleTopico(topico.get()));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var topico = repository.findById(id);
        if (topico.isPresent()) {
            repository.delete(topico.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity actualizarStatus(@PathVariable Long id, @RequestBody @Valid DatosActualizacionStatus datos) {
        var topico = repository.findById(id);

        if (topico.isPresent()) {
            Topico t = topico.get();
            t.setStatus(datos.status());
            return ResponseEntity.ok(new DatosDetalleTopico(t));
        }
        return ResponseEntity.notFound().build();

    }

}






