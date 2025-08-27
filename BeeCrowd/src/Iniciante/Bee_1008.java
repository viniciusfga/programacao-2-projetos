package Iniciante;

import java.io.IOException;
import java.util.Scanner;

public class Bee_1008 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numeroFuncionario = sc.nextInt();
        double numeroHoras = sc.nextDouble();
        double valorHora = sc.nextDouble();

        double salario = numeroHoras * valorHora;

        System.out.printf("NUMBER = %d%n", numeroFuncionario);
        System.out.printf("SALARY = U$ %.2f%n", salario);

    }
}
