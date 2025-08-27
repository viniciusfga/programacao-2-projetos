package Iniciante;

import java.util.Scanner;

public class Bee_1018 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int valor = sc.nextInt();

        int[] cedulas = {100, 50, 20, 10, 5, 2, 1};

        System.out.println(valor);

        for(int i = 0; i < cedulas.length; i++){
            int quantidade = valor / cedulas[i];
            System.out.printf("%d nota(s) de R$ %d,00%n", quantidade, cedulas[i]);
            valor = valor - quantidade * cedulas[i];
        }

        sc.close();
    }
}
