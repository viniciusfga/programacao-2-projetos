package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Somar elementos de uma matriz 3x3.");

        int[][] matriz = {
                {1, 2 ,3},
                {1, 2 ,3},
                {1, 2 ,3}
        };
        int soma = 0;

        // Somar elementos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                soma += matriz[i][j];
            }
        }

        System.out.println("A soma de todos os elementos é: " + soma);
        sc.close();

    }
}
