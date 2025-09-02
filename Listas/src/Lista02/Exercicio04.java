package Lista02;

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor de A: ");
        double A = input.nextDouble();

        double soma = 0.0;
        double termo;

        for (int i = 0; i < 40; i++) {
            termo = (7 * A) / (3 * Math.pow(2, i));
            soma += termo;
        }

        System.out.println("A soma dos 40 primeiros termos é: " + soma);

        input.close();
    }
}

