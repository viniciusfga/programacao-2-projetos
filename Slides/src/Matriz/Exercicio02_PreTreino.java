package Matriz;

import java.util.Scanner;

public class Exercicio02_PreTreino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Exibir as (n) linhas do triângulo de pascal");

        System.out.println("Número de linhas: ");
        int cont = 1, valor;

        int LINHAS = sc.nextInt();
        LINHAS --;

        for (int i = 1; i <= LINHAS; i++) {

            valor = 1;
            System.out.print(valor);
            System.out.println("  ");

            for (i = 1; i <= LINHAS; i++) {

                valor = 1;
                System.out.print(valor + " ");

                for (int j = 1; j <= i; j++) {

                    valor = (valor * (i - j + 1)) / j;

                    System.out.print(valor + " ");
                }
                System.out.println("  ");
            }

        }
    }
}
