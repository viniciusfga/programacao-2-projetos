package Lista01;

import java.util.Scanner;

public class Exercicio31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Simular caixa eletrônico até saldo zerar.");

        double saldo = 1000;

        while (saldo > 0) {
            System.out.println("Saldo atual: R$" + saldo);
            System.out.println("Quanto deseja sacar?");
            double saque = sc.nextDouble();

            if (saque <= saldo) {
                saldo -= saque;
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        }

        System.out.println("Saldo zerado. Operação encerrada.");
        sc.close();
    }
}

