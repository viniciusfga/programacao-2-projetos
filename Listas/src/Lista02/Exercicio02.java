package Lista02;

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro termo (a1): ");
        int a1 = input.nextInt();

        System.out.print("Digite a razão (r): ");
        int r = input.nextInt();

        System.out.print("Digite o número de termos (N): ");
        int n = input.nextInt();

        int soma = (n * (2 * a1 + (n - 1) * r)) / 2;

        System.out.println("A soma dos " + n + " primeiros termos da PA é: " + soma);

        input.close();
    }
}
