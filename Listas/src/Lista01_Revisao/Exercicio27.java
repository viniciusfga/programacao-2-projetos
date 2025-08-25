package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inverter triângulo de asteriscos do exercício anterior.");

        System.out.println("Digite o números de linhas");
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            for (int j = N; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
