/*Você tem que dar o troco de uma quantia em dinheiro usando o menor número possível de moedas.

Exemplos:

Entrada: Quantia 18, Moedas disponíveis 5, 2 e 1
Saída: 5 (três moedas de cinco, uma de 2 e uma de 1)

} */

public class exercicio2 {

    public void troco(int n) {
        int a = 0; // 5
        int b = 0; // 2
        int c = 0; // 1

        for (; n >= 5; n -= 5, a++)
            ;

        for (; n >= 2; n -= 2, b++)
            ;

        for (; n >= 1; n -= 1, c++)
            ;

        System.out.println(a + " Moedas de 5,");
        System.out.println(b + " Moedas de 2,");
        System.out.println(c + " Moedas de 1.");

    }

    public void troco2(int n) {
        int a = 0; // 5
        int b = 0; // 2
        int c = 0; // 1

        while (n >= 5) {
            a++;
            n -= 5;
        }

        while (n >= 2) {
            b++;
            n -= 2;
        }

        while (n >= 1) {
            c++;
            n -= 1;
        }

        System.out.println(a + " Moedas de 5,");
        System.out.println(b + " Moedas de 2,");
        System.out.println(c + " Moedas de 1.");
    }

    public static void main(String[] args) {
        exercicio2 obj = new exercicio2();
        obj.troco(18);
        System.out.println("-----");
        exercicio2 obj2 = new exercicio2();
        obj2.troco2(96);
    }

}
