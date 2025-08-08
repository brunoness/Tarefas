package com.tarefa43.tarefa43;

// Desafio – Implemente um mapa de hash do zero

class Entry {
    int chave;
    int valor;
    Entry colisao;

    public Entry(int chave, int valor) {
        this.chave = chave;
        this.valor = valor;
        this.colisao = null;
    }
}

public class Desafio {
    private final int capacidade = 10;
    private Entry[] tabela;

    public Desafio() {
        tabela = new Entry[capacidade];
    }

    private int hash(int chave) {
        return chave % capacidade;
    }

    public void put(int chave, int valor) {
        int index = hash(chave);
        Entry atual = tabela[index];

        while (atual != null) {
            if (atual.chave == chave) {
                atual.valor = valor;
                return;
            }
            atual = atual.colisao;
        }

        Entry novo = new Entry(chave, valor);
        novo.colisao = tabela[index];
        tabela[index] = novo;
    }

    public Integer get(int chave) {
        int index = hash(chave);
        Entry atual = tabela[index];

        while (atual != null) {
            if (atual.chave == chave) {
                return atual.valor;
            }
            atual = atual.colisao;
        }

        return null; // chave não encontrada
    }

    public boolean delete(int chave) {
        int index = hash(chave);
        Entry atual = tabela[index];
        Entry anterior = null;

        while (atual != null) {
            if (atual.chave == chave) {
                if (anterior == null) {
                    tabela[index] = atual.colisao;
                } else {
                    anterior.colisao = atual.colisao;
                }
                return true;
            }
            anterior = atual;
            atual = atual.colisao;
        }

        return false;
    }

    public void clear() {
        tabela = new Entry[capacidade];
    }

    public void printMap() {
        for (int i = 0; i < capacidade; i++) {
            System.out.print("Índice " + i + ": ");
            Entry atual = tabela[i];
            while (atual != null) {
                System.out.print("[" + atual.chave + " → " + atual.valor + "] ");
                atual = atual.colisao;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Desafio mapa = new Desafio();

        mapa.put(8, 392);
        mapa.put(1, 111);
        mapa.put(11, 399);
        mapa.put(2, 259);
        mapa.put(3, 128);
        System.out.println("");
        mapa.printMap();
        System.out.println("");
        System.out.println("Valor da chave 11: " + mapa.get(11));
        System.out.println("");
        System.out.println("Valor da chave 8: " + mapa.get(8));
        System.out.println("");
        mapa.delete(11);
        mapa.printMap();
        System.out.println("");
        mapa.clear();
        mapa.printMap();
    }
}
