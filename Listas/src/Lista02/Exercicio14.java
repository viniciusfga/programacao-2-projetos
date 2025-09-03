package Lista02;

import java.util.Scanner;

public class Exercicio14 {
    public static void permutar(char[] palavra, int inicio, int fim) {
        if (inicio == fim) {
            System.out.println(new String(palavra));
        } else {
            for (int i = inicio; i <= fim; i++) {
                trocar(palavra, inicio, i);
                permutar(palavra, inicio + 1, fim);
                trocar(palavra, inicio, i); // volta para estado anterior
            }
        }
    }

    private static void trocar(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        permutar(palavra.toCharArray(), 0, palavra.length() - 1);

        sc.close();
    }
}

