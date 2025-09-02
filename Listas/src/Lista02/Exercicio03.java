package Lista02;

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor de N: ");
        int n = input.nextInt();

        double soma = 0.0;

        for (int i = 1; i <= n; i++) {
            soma += 1.0 / (2 * i); // cada termo é 1/(2*i)
        }

        System.out.println("A soma dos " + n + " primeiros termos é: " + soma);

        input.close();
    }
}
