package com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.topico;


import jakarta.validation.constraints.NotNull;

public record DatosActualizacionStatus(
        @NotNull Status status
) {
}
