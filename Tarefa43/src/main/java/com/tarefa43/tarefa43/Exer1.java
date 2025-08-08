package com.tarefa43.tarefa43;

// Exercício 1 – Implemente uma pilha

public class Exer1 {
    private int[] elementos;
    private int topo;
    private int tamanho;

    public Exer1() {
        this.tamanho = 10;
        this.elementos = new int[tamanho];
        this.topo = -1;
    }

    public void push(int valor) {
        if (topo == tamanho - 1) {
            System.out.println("Pilha cheia");
        }
        elementos[++topo] = valor;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }
        return elementos[topo--];
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }

    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Exer1 pilha = new Exer1();

        System.out.println(" ");
        System.out.println("Está vazia? " + pilha.isEmpty());
        System.out.println(" ");
        pilha.push(33);
        pilha.push(12);
        pilha.push(16);
        pilha.push(23);
        pilha.push(36);
        pilha.push(45);
        pilha.push(57);
        pilha.push(89);
        pilha.push(1);
        pilha.push(92);
        pilha.imprimirPilha();
        System.out.println(" ");
        System.out.println("Topo: " + pilha.top());
        System.out.println(" ");
        System.out.println("Pop: " + pilha.pop());
        System.out.println(" ");
        System.out.println("Novo topo: " + pilha.top());
        System.out.println(" ");
        System.out.println("Tamanho: " + pilha.size());
        System.out.println(" ");
        System.out.println("Está vazia? " + pilha.isEmpty());
    }

}
