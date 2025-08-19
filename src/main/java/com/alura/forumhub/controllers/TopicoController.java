package com.alura.forumhub.controllers;

import com.alura.forumhub.modelos.DadosAtualizaTopico;
import com.alura.forumhub.modelos.DadosCadastroTopico;
import com.alura.forumhub.modelos.Topico;
import com.alura.forumhub.repositorios.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> listar(){
        return topicoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Topico> consultarPorId(@PathVariable Integer id){
        var topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            return ResponseEntity.ok(topico.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        var topicoExistente = topicoRepository.findByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if(!topicoExistente.isPresent()){
            var topico = new Topico(dados);
            topicoRepository.save(topico);
            var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(uri).body(topico);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Topico> atualizar(@PathVariable Integer id, @RequestBody @Valid DadosAtualizaTopico dados){
        var topicoSalvo = topicoRepository.findById(id);
        if (topicoSalvo.isPresent()){
            var topico = topicoSalvo.get();
            topico.Atualiza(dados);
            return ResponseEntity.ok(topicoRepository.save(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Integer id){
        var topicoSalvo = topicoRepository.findById(id);
        if (topicoSalvo.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
