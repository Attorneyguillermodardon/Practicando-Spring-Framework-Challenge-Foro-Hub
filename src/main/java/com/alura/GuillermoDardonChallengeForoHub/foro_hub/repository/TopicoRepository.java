package com.alura.GuillermoDardonChallengeForoHub.foro_hub.repository;

import com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

    Page<Topico> findByCursoAndFechaBetween(String curso, LocalDateTime inicio, LocalDateTime fin, Pageable paginacion);

    Boolean existsByTitulo(String titulo);

}
