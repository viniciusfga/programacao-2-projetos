package HotelariaFace;

import HotelariaFace.Gerenciar;
import Hotelaria.Utils;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {

        Gerenciar gerenciar = new Gerenciar();

        int opcao = 0;
        do {
            System.out.println("\n=== Sistema Hostelaria ===");
            System.out.println("1. Gerenciar Hóspedes");
            System.out.println("2. Gerenciar Quartos");
            System.out.println("3. Gerenciar Reservas");
            System.out.println("4. Sair");

            try {
                opcao = Utils.lerInt("Escolha uma opção: ");

                switch (opcao) {
                    case 1 -> gerenciar.gerenciarHospedes();
                    case 2 -> gerenciar.gerenciarQuartos();
                    case 3 -> gerenciar.gerenciarReservas();
                    case 4 -> System.out.println("\nEncerrando o sistema...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número válido");
            }
        } while (opcao != 2);

    }
}
