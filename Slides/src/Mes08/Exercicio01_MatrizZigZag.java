package Mes08;
import java.util.ArrayList;
import java.util.List;

public class Exercicio01_MatrizZigZag {
    public static void main(String[] args) {

        int[][] matriz = {
                {00, 01, 02, 03, 04},
                {10, 11, 12, 13, 14},
                {20, 21, 22, 23, 24},
                {30, 31, 32, 33, 34},
                {40, 41, 42, 43, 44}

        };


        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for (int d = 0; d <= linhas + colunas - 2; d++) {
            if (d % 2 == 0) {
                // percorre de cima para baixo (linha começa no min(d, linhas-1))
                for (int i = Math.min(d, linhas - 1); i >= 0; i--) {
                    int j = d - i;
                    if (j >= 0 && j < colunas) {
                        System.out.print(matriz[i][j] + " ");
                    }
                }
            } else {
                // percorre de baixo para cima (linha começa no max(0, d-colunas+1))
                for (int i = Math.max(0, d - colunas + 1); i < linhas; i++) {
                    int j = d - i;
                    if (j >= 0 && j < colunas) {
                        System.out.print(matriz[i][j] + " ");
                    }
                }
            }
        }


    }
}
