package Lista02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a quantidade de nomes: ");
        int n = input.nextInt();
        input.nextLine(); // consumir a quebra de linha após nextInt

        String[] nomes = new String[n];

        System.out.println("Digite os " + n + " nomes:");
        for (int i = 0; i < n; i++) {
            nomes[i] = input.nextLine();
        }

        // Ordena o array em ordem alfabética
        Arrays.sort(nomes);

        System.out.println("\nNomes em ordem alfabética:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        input.close();

    }
}
