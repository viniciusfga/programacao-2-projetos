package Hotelaria;

import Hotelaria.services.HospedeService;
import Hotelaria.services.QuartoService;
import Hotelaria.services.ReservaService;

public class MenuController {

    HospedeService hospede = new HospedeService();
    QuartoService quarto = new QuartoService();
    ReservaService reserva = new ReservaService();

    // GERENCIAR HOSPEDES
    public void abrirMenuHospedes() {
        int escolha = Utils.lerInt("""
                \n=== Gerenciar Hóspedes ===
                  1) Cadastrar hóspede
                  2) Listar hóspedes
                  3) Remover hóspede
                  4) Apagar todos
                  5) Atualizar Dados
                  6) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> hospede.cadastrarHospede();
            case 2 -> hospede.listarHospedes();
            case 3 -> hospede.removerHospede();
            case 4 -> hospede.apagarTodos();
            case 5 -> hospede.atualizarHospede();
            case 6 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

    // GERENCIAR QUARTOS
    public void abrirMenuQuartos() {
        int escolha = Utils.lerInt("""
                \n=== Gerenciar Quartos ===
                  1) Cadastrar Quarto
                  2) Listar Quartos
                  3) Remover Quarto
                  4) Apagar Todos
                  5) Buscar Por Nome
                  6) Modificar
                  7) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> quarto.cadastrarQuarto();
            case 2 -> quarto.listarQuartos();
            case 3 -> quarto.removerQuarto();
            case 4 -> quarto.apagarTodos();
            case 5 -> quarto.buscarPorNumeroMenu();
            case 6 -> quarto.atualizarQuartoMenu();
            case 7 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

    // GERENCIAR RESERVAS
    public void abrirMenuReservas() {
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

    // MENU LOCALIZAR
    public void abrirMenuLocalizar() {
        int escolha = Utils.lerInt("""
                \n=== Menu de Busca ===
                  1) Hóspede
                  2) Quarto
                  3) Reserva
                  4) Sair
                  Escolha: """);

        switch (escolha) {
            case 1 -> hospede.buscarHospede();
            case 2 -> quarto.buscarQuarto();
            case 3 -> reserva.buscarReserva();
            case 4 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }

}

