import java.math.BigInteger;

/**
 * Problema: resolva o exercício 2 com programação dinâmica. Crie um algoritmo
 * com abordagem top down e outro com bottom up e explique as diferenças entre
 * a solução do exercício 2 e a do exercício 3.
 * 
 * Fatorial:
 * Top Down: Recursão com memorização, armazena resultados intermediários.
 * Bottom Up: Iterativo, constrói solução a partir de casos base.
 * Diferenças:
 * - Top Down usa recursão e memoização, consome mais memória por causa da pilha
 * de chamadas.,
 * - Bottom Up é iterativo, consome menos memória e é mais eficiente em termos
 * de tempo.
 * - Complexidade de tempo é O(n) para ambos e memória é O(n) para Top Down e
 * O(1) para Bottom Up.
 * 
 * 
 * Fibonacci:
 * Problemas como Fibonacci têm sobreposição de subproblemas e mais de
 * uma chamada recursiva por passo (f(n) = f(n-1) + f(n-2)),
 * - Complexidade O(2^n), memória O(n)
 * 
 * Fatorial não sofre tanto, porque é só uma chamada por nível.
 */

public class exercicio2 {

    public static int fatorialTopDown(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = n * fatorialTopDown(n - 1, memo);
        return memo[n];
    }

    public static int fatorialBottomUp(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // necessário usar BigInteger para numeros grandes pois int não suporta.
    public static BigInteger fatorialBigInteger(BigInteger m) {
        BigInteger resultado = BigInteger.ONE;
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(m) <= 0; i = i.add(BigInteger.ONE)) {
            resultado = resultado.multiply(i);
        }
        return resultado;
    }

    public static void main(String[] args) {
        int n = 7;
        BigInteger m = BigInteger.valueOf(99);
        int[] memo = new int[n + 1];

        System.out.println("Fatorial de " + n + " (Top Down) = " + fatorialTopDown(n, memo));
        System.out.println("Fatorial de " + n + " (Bottom Up) = " + fatorialBottomUp(n));

        System.out.println("Fatorial de " + m + " (BigInteger) = " + fatorialBigInteger(m));

    }

}
