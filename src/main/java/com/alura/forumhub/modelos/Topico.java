package com.alura.forumhub.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String mensagem;
    private Date dataCriacao;
    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;
    private String autor;
    private String curso;

    public Topico(DadosCadastroTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = Date.from(Instant.now());
        this.estadoTopico = EstadoTopico.OPEN;
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public void Atualiza(DadosAtualizaTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        if (dados.estadoTopico() == null){
            this.estadoTopico = EstadoTopico.OPEN;
        } else{
            this.estadoTopico = dados.estadoTopico();
        }

        this.autor = dados.autor();
        this.curso = dados.curso();
    }
}
