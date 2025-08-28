package Iniciante;

import java.io.IOException;
import java.util.Scanner;

public class Bee_1010 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int codigo1 = sc.nextInt();
        int quantidade1 = sc.nextInt();
        double valorUnitario1 = sc.nextDouble();

        // Lendo a segunda peça
        int codigo2 = sc.nextInt();
        int quantidade2 = sc.nextInt();
        double valorUnitario2 = sc.nextDouble();

        // Calculando o valor total
        double total = (quantidade1 * valorUnitario1) + (quantidade2 * valorUnitario2);


        System.out.printf("VALOR A PAGAR: R$ %.2f%n", total);

    }
}
