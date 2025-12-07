package Lista01;

import java.util.Scanner;

public class Exercicio26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Construir matriz com triângulo de asteriscos (n linhas).");

        System.out.println("Digite o números de linhas");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
