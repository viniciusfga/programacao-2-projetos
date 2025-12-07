package Lista01;

import java.util.Scanner;

public class Exercicio35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calcular juros compostos com depósitos, tempo e taxa anual.");

        System.out.print("Digite o depósito inicial (P): ");
        double principal = sc.nextDouble();

        System.out.print("Digite a taxa de juros anual (em decimal, ex: 0.05 para 5%): ");
        double taxaAnual = sc.nextDouble();

        System.out.print("Digite o tempo em anos (t): ");
        double tempoAnos = sc.nextDouble();

        System.out.print("Digite a frequência de capitalização por ano (n): ");
        double capitalizacaoAnual = sc.nextDouble();

        // Calcular o montante final
        // A fórmula é M = P * (1 + r/n)^(n*t)
        // M = montante final
        // P = principal
        // r = taxa de juros anual (taxaAnual)
        // n = frequência de capitalização anual (capitalizacaoAnual)
        // t = tempo em anos (tempoAnos)

        double montanteFinal = principal * Math.pow(1 + (taxaAnual / capitalizacaoAnual), capitalizacaoAnual * tempoAnos);

        double jurosTotais = montanteFinal - principal;

        System.out.println("\n--- Resultados ---");
        System.out.printf("Depósito Inicial (P): R$ %.2f%n", principal);
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", taxaAnual * 100);
        System.out.printf("Tempo: %.2f anos%n", tempoAnos);
        System.out.printf("Capitalização: %s vezes por ano%n", capitalizacaoAnual);
        System.out.printf("Montante Final (M): R$ %.2f%n", montanteFinal);
        System.out.printf("Juros Totais: R$ %.2f%n", jurosTotais);

        sc.close();

    }
}
