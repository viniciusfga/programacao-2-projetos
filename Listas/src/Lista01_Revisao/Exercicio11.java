package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular média de números inseridos pelo usuário.");

        int i = 0, n = 0, soma = 0;

        System.out.println("Quantos números irá digitar?");
        int qtd = sc.nextInt();

        while ( i < qtd ) {
            n = sc.nextInt();
            soma = soma + n;
            i++;
        }
        int media =  soma / qtd;
        System.out.println("Média: " + media);
        sc.close();

    }
}
