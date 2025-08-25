package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Encontrar mínimo e máximo em lista sem funções prontas.");

        System.out.print("Quantos números deseja digitar? ");
        int n = sc.nextInt();

        int[] numeros = new int[n];

        // Leitura dos números
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i+1) + ": ");
            numeros[i] = sc.nextInt();
        }

        int min = numeros[0];
        int max = numeros[0];

        for (int i = 1; i < n; i++) {
            if (numeros[i] < min) {
                min = numeros[i];
            }
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }

        System.out.println("Menor valor: " + min);
        System.out.println("Maior valor: " + max);

        sc.close();

    }
}
