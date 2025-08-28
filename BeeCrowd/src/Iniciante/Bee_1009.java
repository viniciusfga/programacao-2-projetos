package Iniciante;

import java.io.IOException;
import java.util.Scanner;

public class Bee_1009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String nomeVendedor = sc.nextLine();
        double salarioFixo   = sc.nextDouble();
        double valorVendas   = sc.nextDouble();

        double salario = salarioFixo + valorVendas * 0.15;

        System.out.printf("TOTAL = R$ %.2f%n", salario);

    }
}
