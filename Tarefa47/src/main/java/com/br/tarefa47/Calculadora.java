package com.br.tarefa47;

public class Calculadora {

    private int somar(int a, int b) {
        return a + b;
    }

    private int subtrair(int a, int b) {
        return a - b;
    }

    private int multiplicar(int a, int b) {
        return a * b;
    }

    private int dividir(int a, int b) {
        if (b == 0) {
            System.out.println("Divisão por zero não é permitida.");
        }
        return (int) a / b;
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int somarPublic(int a, int b) {
        return somar(a, b);
    }

    public int subtrairPublic(int a, int b) {
        return subtrair(a, b);
    }

    public int multiplicarPublic(int a, int b) {
        return multiplicar(a, b);
    }

    public int dividirPublic(int a, int b) {
        if (b == 0) {
            System.out.println("Divisão por zero não é permitida.");
        }
        return dividir(a, b);
    }

    public int fibonacciPublic(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
