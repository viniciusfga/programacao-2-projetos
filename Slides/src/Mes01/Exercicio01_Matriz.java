package Mes01;

public class Exercicio01_Matriz {
    public static void main(String[] args) {

        int[][] matriz = {
                {00, 01, 02, 03, 04},
                {10, 11, 12, 13, 14},
                {20, 21, 22, 23, 24},
                {30, 31, 32, 33, 34},
                {40, 41, 42, 43, 44}

        };

        /*
        for (int d = 0; d <= matriz.length + matriz[0].length - 2; d++) {
            if (d % 2 == 0) { // diagonal par: de cima para baixo
                int r = Math.min(d, matriz.length - 1);
                int c = d - r;
                while (r >= 0 && c < matriz[0].length) {
                    System.out.print(matriz[r][c] + " ");
                    r--;
                    c++;
                }
            } else { // diagonal ímpar: de baixo para cima
                int c = Math.min(d, matriz[0].length - 1);
                int r = d - c;
                while (r < matriz.length && c >= 0) {
                    System.out.print(matriz[r][c] + " ");
                    r++;
                    c--;
                }
            }
        }
        */


    }
}
