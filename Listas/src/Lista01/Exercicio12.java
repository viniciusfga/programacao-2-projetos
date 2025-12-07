package Lista01;

import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular fatorial de um número informado.");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Fatorial não é definido para números negativos.");
            sc.close();
            return;
        }

        long fat = 1;
        for (int i = n; i > 0; i--) {
            fat *= i;
        }

        System.out.println("O fatorial de " + n + " é " + fat);

        sc.close();;
    }
}
