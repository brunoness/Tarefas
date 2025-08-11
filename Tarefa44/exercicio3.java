/*
 * Calcule a complexidade de tempo das soluções da série de Fibonacci
apresentadas no módulo e compare as duas.

Recursiva pura:       Tempo:O(2^n)	        Espaço:O(n)
Recursiva dinamica:   Tempo:O(n)	        Espaço:O(n)

A implementação recursiva pura tem complexidade exponencial, pois 
recalcula os mesmos valores várias vezes.
já a implementação dinâmica armazena os resultados intermediários, 
reduzindo a complexidade, o que a torna muito mais eficiente para 
valores maiores é muito mais eficiente e prática para números grandes.
 * 
 */

import java.math.BigInteger;

public class exercicio3 {

    public static int fibonacciPuro(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciPuro(n - 1) + fibonacciPuro(n - 2);
    }

    // necessário usar BigInteger para numeros grandes pois int não suporta.
    public static BigInteger fibDinamico(int n, BigInteger[] memo) {
        if (memo[n] != null)
            return memo[n];
        if (n < 2)
            memo[n] = BigInteger.valueOf(n);
        else
            memo[n] = fibDinamico(n - 1, memo).add(fibDinamico(n - 2, memo));
        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println("Fibonacci com Recursividade pura (12): " + fibonacciPuro(12));
        // System.out.println("Fibonacci com Recursividade pura (100): " + fibonacciPuro(100)); // Causará erro de Recursão Máxima

        int n = 100;
        BigInteger[] memo = new BigInteger[n + 1];
        System.out.println("Fibonacci com Programação Dinâmica (" + n + "): " + fibDinamico(n, memo));
    }
}
