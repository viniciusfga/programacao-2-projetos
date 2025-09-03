package Lista02;

import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a profundidade N: ");
        int N = sc.nextInt();

        // fórmula mínima
        int resultado = (3 * N * (N - 1)) / 2 + 1;

        System.out.println("Mínimo de alvéolos a preencher manualmente: " + resultado);

        sc.close();

    }
}
