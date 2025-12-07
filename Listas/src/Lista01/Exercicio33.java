package Lista01;

public class Exercicio33 {
    public static void main(String[] args) {

        System.out.println("Construir pirâmide numérica com números consecutivos.");

        int N = 10, k = 1;

        for (int i = 1; i < N; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(k + " ");
                k ++;

            }
            System.out.println();
        }

    }
}
