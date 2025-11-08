package HotelariaV1;

import Hotelaria.Gerenciar;
import HotelariaV1.Utils;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Hotelaria.Gerenciar gerenciar = new Gerenciar(hospedeService);

        int opcao;

        do {
            System.out.println("\n=== Sistema Hostelaria ===");
            System.out.println("1. Gerenciar hóspedes");
            System.out.println("2. Gerenciar quartos");
            System.out.println("3. Gerenciar reservas");
            System.out.println("4. Sair");

            opcao = Utils.lerInt("Escolha uma opção: ");

            try {
                switch (opcao) {
                    case 1 -> gerenciar.gerenciarHospede();
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número");
            }
        } while (opcao != 4);

    }
}
