package Lista02;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = sc.nextInt();
        int soma = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                soma += i;
            }
        }

        if (soma == numero) {
            System.out.println(numero + " é um número perfeito.");
        } else {
            System.out.println(numero + " não é um número perfeito.");
        }

        sc.close();

    }
}
