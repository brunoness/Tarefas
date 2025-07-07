package com.bruno.service;

import com.bruno.model.Elemento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PilhaService {
    private Stack<Elemento> pilha = new Stack<>();

    public void empilhar(Elemento elemento) {
        pilha.push(elemento);
    }

    public Elemento desempilhar() {
        if (pilha.isEmpty())
            return null;
        return pilha.pop();
    }

    public Elemento topo() {
        if (pilha.isEmpty())
            return null;
        return pilha.peek();
    }

    public int tamanho() {
        return pilha.size();
    }

    public boolean estaVazia() {
        return pilha.isEmpty();
    }

    public List<Elemento> getTodos() {
        return new ArrayList<>(pilha);
    }
}