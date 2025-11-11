package HotelariaPOO;

import HotelariaPOO.services.HospedeService;
import HotelariaPOO.services.QuartoService;
import HotelariaPOO.services.ReservaService;
import HotelariaPOO.utils.Utils;

public class App {
    public static void main(String[] args) {

        HospedeService hospedeService = new HospedeService();
        QuartoService quartoService = new QuartoService();
        ReservaService reservaService = new ReservaService();

        // CARREGAR DADOS EXISTENTES
        hospedeService.carregarArquivo();
        quartoService.carregarArquivo();
        reservaService.carregarArquivo(hospedeService, quartoService);

        Gerenciar gerenciar = new Gerenciar(hospedeService, quartoService, reservaService);

        int opcao;
        do {
            System.out.println("\n=== Sistema Hostelaria ===");
            System.out.println("1. Gerenciar hóspedes");
            System.out.println("2. Gerenciar quartos");
            System.out.println("3. Gerenciar reservas");
            System.out.println("4. Sair");

            opcao = Utils.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> gerenciar.gerenciarHospedes();
                case 2 -> gerenciar.gerenciarQuartos();
                case 3 -> gerenciar.gerenciarReservas();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
}
