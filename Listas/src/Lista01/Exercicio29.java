package Lista01;

import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Criar matriz identidade de ordem n.");

        System.out.println("Digite a ordem da matriz: ");

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        

    }
}
