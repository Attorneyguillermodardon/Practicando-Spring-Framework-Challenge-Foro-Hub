package com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.topico;


import java.time.LocalDateTime;

public record DatosDetalleTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String curso

) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()

        );
    }
}
