package Hotelaria;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {

        Gerenciar gerenciar = new Gerenciar();

        int opcao = 0;
        do {
            System.out.println("\n=== Sistema Hostelaria ===");
            System.out.println("1. Gerenciar hóspedes");
            System.out.println("2. Sair");

            try {
                opcao = Utils.lerInt("Escolha uma opção: ");

                switch (opcao) {
                    case 1 -> gerenciar.gerenciarHospedes();
                    case 2 -> System.out.println("\nEncerrando o sistema...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número válido");
            }
        } while (opcao != 2);

    }
}
