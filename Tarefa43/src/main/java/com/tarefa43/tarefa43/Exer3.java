package com.tarefa43.tarefa43;

// Exercício 3 – Implemente uma lista encadeada

class Node {
    int valor;
    Node proximo;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}

public class Exer3 {
    private Node inicio;
    private int tamanho;

    public void push(Node node) {
        if (inicio == null) {
            inicio = node;
        } else {
            Node atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        tamanho++;
    }

    public Node pop() {
        if (inicio == null) {
            return null;
        }

        if (inicio.proximo == null) {
            Node temp = inicio;
            inicio = null;
            tamanho--;
            return temp;
        }

        Node anterior = null;
        Node atual = inicio;
        while (atual.proximo != null) {
            anterior = atual;
            atual = atual.proximo;
        }

        anterior.proximo = null;
        tamanho--;
        return atual;
    }

    public void insert(int index, Node node) {
        if (index < 0 || index > tamanho) {
            System.out.println("Índice inválido");
        }

        if (index == 0) {
            node.proximo = inicio;
            inicio = node;
        } else {
            Node atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            node.proximo = atual.proximo;
            atual.proximo = node;
        }

        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice inválido");
        }

        if (index == 0) {
            inicio = inicio.proximo;
        } else {
            Node atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }

        tamanho--;
    }

    public Node elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            System.out.println("Índice inválido");
        }

        Node atual = inicio;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }

        return atual;
    }

    // Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Imprime a lista como texto
    public void printList() {
        Node atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Exer3 lista = new Exer3();

        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));
        lista.printList();

        lista.insert(1, new Node(15));
        lista.printList();
        lista.remove(2);
        lista.printList();

        Node ultimo = lista.pop();
        System.out.println("");
        System.out.println("Elemento removido: " + ultimo);
        System.out.println("");
        lista.printList();
        System.out.println("");
        System.out.println("Elemento na posição 1: " + lista.elementAt(1));
        System.out.println("");
        System.out.println("Tamanho da lista: " + lista.size());
    }

}
