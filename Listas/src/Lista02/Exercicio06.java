package Lista02;

import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a quantidade de números: ");
        int n = input.nextInt();

        if (n < 2) {
            System.out.println("É necessário pelo menos dois números.");
            input.close();
            return;
        }

        int maior = Integer.MIN_VALUE;
        int segundoMaior = Integer.MIN_VALUE;

        System.out.println("Digite os " + n + " números:");

        for (int i = 0; i < n; i++) {
            int num = input.nextInt();

            if (num > maior) {
                segundoMaior = maior;   // o antigo maior vira segundo maior
                maior = num;
            } else if (num > segundoMaior && num != maior) {
                segundoMaior = num;     // atualiza o segundo maior
            }
        }

        if (segundoMaior == Integer.MIN_VALUE) {
            System.out.println("Não há segundo maior (todos os números iguais).");
        } else {
            System.out.println("O segundo maior número é: " + segundoMaior);
        }

        input.close();
    }
}
