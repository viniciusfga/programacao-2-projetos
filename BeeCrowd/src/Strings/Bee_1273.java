package Strings;

import java.util.Scanner;

public class Bee_1273 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N;
        boolean primeiroCaso = true;

        while ((N = sc.nextInt()) != 0) {
            sc.nextLine();

            if (!primeiroCaso) {
                System.out.println();
            }
            primeiroCaso = false;

            String[] linhas = new String[N];
            int tamanhoMaximo = 0;

            for (int i = 0; i < N; i++) {
                String linhaOriginal = sc.nextLine();
                // 1. .trim() remove espaços do início e do fim.
                // 2. .replaceAll() substitui múltiplos espaços por um único espaço.
                String linhaLimpa = linhaOriginal.trim().replaceAll("\\s+", " ");
                linhas[i] = linhaLimpa;

                if (linhaLimpa.length() > tamanhoMaximo) {
                    tamanhoMaximo = linhaLimpa.length();
                }
            }


            for (int i = 0; i < N; i++) {
                String linhaAtual = linhas[i];

                int numEspacos = tamanhoMaximo - linhaAtual.length();

                for (int j = 0; j < numEspacos; j++) {
                    System.out.print(" ");
                }
                System.out.println(linhaAtual);
            }
        }

        sc.close();
    }
}