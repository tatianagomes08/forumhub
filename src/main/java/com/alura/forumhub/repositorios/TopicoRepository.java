package com.alura.forumhub.repositorios;

import com.alura.forumhub.modelos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Integer> {
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);
}
