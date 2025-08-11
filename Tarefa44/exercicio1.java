/**
 * Problema: crie um código que calcule o fatorial de um número
 * 
 * Cada linguagem tem sua limitação, em algumas linguagens é possível calcular o
 * fatorial de 100 e de outros números muito grandes dentro do limite.
 * portanto não é recomendado fazer dessa forma, nos próximos exercícios vamos
 * ver como resolver isso de forma mais eficiente.
 */

public class exercicio1 {

    public static int fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Fatorial de 3 = " + fatorial(3));
        System.out.println("Fatorial de 7 = " + fatorial(7));
        System.out.println("Fatorial de 12 = " + fatorial(12));
        System.out.println("Fatorial de 100 = " + fatorial(100)); // Isso causa provavelmente StackOverflowError
    }
}
