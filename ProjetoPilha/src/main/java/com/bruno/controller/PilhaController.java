package com.bruno.controller;

import com.bruno.model.Elemento;
import com.bruno.service.PilhaService;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pilha")
public class PilhaController {

    private final PilhaService pilhaService = new PilhaService();

    @PostMapping("/empilhar")
    public void empilhar(@RequestBody Elemento elemento) {
        pilhaService.empilhar(elemento);
    }

    @DeleteMapping("/desempilhar")
    public Elemento desempilhar() {
        return pilhaService.desempilhar();
    }

    @GetMapping("/topo")
    public Elemento topo() {
        return pilhaService.topo();
    }

    @GetMapping("/tamanho")
    public int tamanho() {
        return pilhaService.tamanho();
    }

    @GetMapping("/vazia")
    public boolean estaVazia() {
        return pilhaService.estaVazia();
    }

    @GetMapping("/todos")
    public List<Elemento> listarTodos() {
        return pilhaService.getTodos();
    }

}