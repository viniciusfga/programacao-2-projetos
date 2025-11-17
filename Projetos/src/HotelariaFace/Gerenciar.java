package HotelariaFace;

import Hotelaria.Utils;
import Hotelaria.services.HospedeService;
import Hotelaria.services.QuartoService;
import Hotelaria.services.ReservaService;

public class Gerenciar {

    HospedeService hospede = new HospedeService();
    QuartoService quarto = new QuartoService();
    ReservaService reserva = new ReservaService();

    // GERENCIAR HOSPEDES
    public void gerenciarHospedes() {
        int escolha = Hotelaria.Utils.lerInt("""
                \n=== Gerenciar Hóspedes ===
                  1) Cadastrar hóspede
                  2) Listar hóspedes
                  3) Remover hóspede
                  4) Apagar todos
                  5) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> hospede.cadastrarHospede();
            case 2 -> hospede.listarHospedes();
            case 3 -> hospede.removerHospede();
            case 4 -> hospede.apagarTodos();
            case 5 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

    // GERENCIAR QUARTOS
    public void gerenciarQuartos() {
        int escolha = Hotelaria.Utils.lerInt("""
                \n=== Gerenciar Quartos ===
                  1) Cadastrar Quarto
                  2) Listar Quartos
                  3) Remover Quarto
                  4) Apagar Todos
                  5) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> quarto.cadastrarQuarto();
            case 2 -> quarto.listarQuartos();
            case 3 -> quarto.removerQuarto();
            case 4 -> quarto.apagarTodos();
            case 5 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

    // GERENCIAR RESERVAS
    public void gerenciarReservas() {
        int escolha = Utils.lerInt("""
                \n=== Gerenciar Reservas ===
                  1) Cadastrar Reserva
                  2) Listar Reservas
                  3) Remover Reserva
                  4) Apagar Reservas
                  5) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> reserva.criarReserva();
            case 2 -> reserva.listarReservas();
            case 3 -> reserva.cancelarReserva();
            case 4 -> reserva.apagarTodas();
            case 5 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }
}

