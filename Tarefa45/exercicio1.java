public class exercicio1 {

    static void backtrack(int[] S, int n, int inicio, int[] comb, int nivel) {
        if (nivel == n) {
            for (int i = 0; i < n; i++) System.out.print(comb[i] + (i < n - 1 ? ", " : ""));
            System.out.println();
            return;
        }
        for (int i = inicio; i < S.length; i++) {
            comb[nivel] = S[i];
            backtrack(S, n, i + 1, comb, nivel + 1);
        }
    }

    public static void main(String[] args){
         int[] S1 = {1, 2, 3};
        backtrack(S1, 2, 0, new int[2], 0);
        System.out.println();
        int[] S2 = {1, 2, 3, 4};
        backtrack(S2, 1, 0, new int[1], 0);
    }
}
