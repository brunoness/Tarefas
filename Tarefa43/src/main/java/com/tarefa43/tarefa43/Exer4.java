package com.tarefa43.tarefa43;

// Exercício 4 – Complexidades assintóticas de tempo e espaço

public class Exer4 {

    /*
    1. PILHA 

        Complexidade de tempo:
        push	O(1)	Incrementa topo e escreve no array. Não percorre todo o Array
        pop	    O(1)	Decrementa topo e retorna valor. Não percorre todo o Array

        Complexidade de espaço:
        O(n), n é o tamanho da pilha.

    2. FILA (Queue)
        
        Complexidade de tempo:
        enqueue	O(1)	Insere em tras e atualiza índice circularmente. Não percorre todo o Array
        dequeue	O(1)	Remove de frente e atualiza índice. Não percorre todo o Array
        front	O(1)	Apenas acessa o índice frente. Não percorre todo o Array
        rear	O(1)	Calcula (tras - 1 + tamanho) % tamanho e acessa direto. Não percorre todo o Array

        Complexidade de espaço:
        O(n), n é o tamanho da fila.

        Como é um array fixo, todo o espaço é alocado antecipadamente.

    3. LISTA ENCADEADA (Linked List)
        
        Complexidade de tempo:
        push	    O(n)	Percorre até o último nó para inserir no final.
        pop	        O(n)	Percorre até o penúltimo nó para desconectar o último.
        insert	    O(n)	Percorre até o índice desejado (pior caso é no fim).
        remove	    O(n)	Percorre até o índice (para desconectar o nó).
        elementAt	O(n)	Percorre até o índice desejado.

        Obs: Todas essas operações seriam O(1) se a lista fosse duplamente encadeada com ponteiro para o último elemento, mas na nessa versão isso não existe.

        Complexidade de espaço:
        O(n), n é a quantidade de nós.

     */
}
