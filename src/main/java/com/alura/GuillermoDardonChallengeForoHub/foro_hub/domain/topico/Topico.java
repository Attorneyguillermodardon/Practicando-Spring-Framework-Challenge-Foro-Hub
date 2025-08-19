package com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


public class Topico {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;

    @Lob
    private String mensaje;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;
    private String curso;


    public Topico(@Valid DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = Status.ABIERTO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }
}
