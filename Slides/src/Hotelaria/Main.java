package Hotelaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("=== Sistema Hostelaria ===");
            System.out.println("1. Gerenciar hóspedes");
            System.out.println("2. Gerenciar quartos");
            System.out.println("3. Gerenciar reservas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Funcionalidade de hóspedes ainda em desenvolvimento...");
                    break;
                case 2:
                    System.out.println("Funcionalidade de quartos ainda em desenvolvimento...");
                    break;
                case 3:
                    System.out.println("Funcionalidade de reservas ainda em desenvolvimento...");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
}
