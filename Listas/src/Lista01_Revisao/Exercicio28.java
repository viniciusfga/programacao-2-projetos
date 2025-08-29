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
        System.out.print("Digite o terceitro número: ");
        int c = sc.nextInt();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Por favor, digite apenas números inteiros positivos.");
            sc.close();
            return;
        }

        int resto;
        int numA = a;
        int numB = b;
        int numC = c;

        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        while (c != 0) {
            resto = b % c;
            b = c;
            c = resto;
        }

        System.out.println("O MDC de " + numA + " , " + numB + " e " + numC + " é: " + a);

        sc.close();

    }
}
