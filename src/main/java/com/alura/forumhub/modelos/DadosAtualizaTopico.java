package com.alura.forumhub.modelos;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        EstadoTopico estadoTopico) {
}
