package Mes1;

public class Exercicio01_MatrizZigZag {
    public static void matrizZigZag(int[][] matriz) {
        int n = matriz.length;

        System.out.println("Percurso ZigZag da Matriz:");

        // A soma dos índices varia de 0 até 2*(n-1)
        for (int s = 0; s <= 2 * (n - 1); s++) {

            // Diagonais pares: percorre de cima para baixo (i decresce, j cresce)
            if (s % 2 == 0) {
                for (int i = 0; i <= s; i++) {
                    int j = s - i;
                    if (i < n && j < n) {
                        System.out.print(matriz[i][j] + " ");
                    }
                }
            }
            // Diagonais ímpares: percorre de baixo para cima (i cresce, j decresce)
            else {
                for (int i = 0; i <= s; i++) {
                    int j = s - i;
                    if (i < n && j < n) {
                        System.out.print(matriz[j][i] + " ");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {0, 1, 2, 3},
                {10, 11, 12, 13},
                {20, 21, 22, 23},
                {30, 31, 32, 33}
        };

        matrizZigZag(matriz);
    }

}

