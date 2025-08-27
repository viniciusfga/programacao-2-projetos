package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Algoritmo de Euclides para calcular MDC.");

        System.out.print("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int b = sc.nextInt();

        if (a <= 0 || b <= 0) {
            System.out.println("Por favor, digite apenas números inteiros positivos.");
            sc.close();
            return;
        }

        int resto;
        int numA = a;
        int numB = b;

        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }

        System.out.println("O MDC de " + numA + " e " + numB + " é: " + a);

        sc.close();

    }
}
