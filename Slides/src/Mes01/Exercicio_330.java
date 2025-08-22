package Mes01;

import java.util.Scanner;

public class Exercicio_330 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int a = sc.nextInt();

        double soma = 0;
        for (int i = 0; i < 40; i++) {
            soma += (7.0 * a / 3) * (2 * i + 1);
        }

        System.out.println("Resultado da soma: " + soma);
        sc.close();
    }
}
