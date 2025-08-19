package com.alura.forumhub.modelos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}
