package com.tarefa43.tarefa43;

// Exercício 2 – Implemente uma pilha FIFO

public class Exer2 {

    private int[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public Exer2() {
        this.capacidade = 10;
        this.elementos = new int[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    public void enqueue(int valor) {
        if (tamanho == capacidade) {
            throw new IllegalStateException("Fila cheia");
        }
        elementos[fim] = valor;
        fim = (fim + 1) % capacidade;
        tamanho++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        int valor = elementos[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return valor;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return elementos[inicio];
    }

    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        int indiceUltimo = (fim - 1 + capacidade) % capacidade;
        return elementos[indiceUltimo];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public void imprimirFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            System.out.print(elementos[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Exer2 fila = new Exer2();

        System.out.println("Está vazia? " + fila.isEmpty());
        System.out.println("");
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(12);
        fila.enqueue(153);
        fila.imprimirFila();
        System.out.println("");
        System.out.println("Front: " + fila.front());
        System.out.println("Rear: " + fila.rear());
        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("");
        fila.imprimirFila();
        System.out.println("");
        System.out.println("Tamanho: " + fila.size());
        System.out.println("");
        System.out.println("Está vazia? " + fila.isEmpty());
    }
}
