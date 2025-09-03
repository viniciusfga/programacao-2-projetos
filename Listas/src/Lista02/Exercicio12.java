package Lista02;

import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a taxa de juros ao mês (em %): ");
        double taxa = sc.nextDouble() / 100; // converte para decimal

        double valorInicial = 100.0; // pode ser qualquer valor
        double valor = valorInicial;
        int meses = 0;

        while (valor < valorInicial * 2) {
            valor *= (1 + taxa);
            meses++;
        }

        System.out.printf("O investimento dobrará em %d meses.%n", meses);

        sc.close();
    }
}
