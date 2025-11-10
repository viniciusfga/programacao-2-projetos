package Hotelaria;

import Hotelaria.models.Hospede;
import Hotelaria.models.Quarto;
import Hotelaria.models.Reserva;
import Hotelaria.services.HospedeService;
import Hotelaria.services.QuartoService;
import Hotelaria.services.ReservaService;
import Hotelaria.utils.Utils;

public class Gerenciar {

    private HospedeService hospedeService;
    private QuartoService quartoService;
    private ReservaService reservaService;

    public Gerenciar(HospedeService hospedeService, QuartoService quartoService, ReservaService reservaService) {
        this.hospedeService = hospedeService;
        this.quartoService = quartoService;
        this.reservaService = reservaService;
    }

    public Gerenciar() {

    }

    // --- Gerenciar Hóspedes ---
    public void gerenciarHospedes() {
        int escolha = Utils.lerInt("""
                \n=== Gerenciar Hóspedes ===
                1 - Cadastrar
                2 - Listar
                3 - Remover
                Escolha: """);

        switch (escolha) {
            case 1 -> {
                String nome = Utils.lerString("Nome: ");
                String cpf = Utils.lerString("CPF: ");
                String rg = Utils.lerString("RG: ");
                String celular = Utils.lerString("Celular: ");
                String email = Utils.lerString("E-mail: ");

                Hospede h = new Hospede();
                h.setNome(nome);
                h.setCpf(cpf);
                h.setRg(rg);
                h.setCelular(celular);
                h.setEmail(email);

                hospedeService.adicionarHospede(h);
                System.out.println("Hóspede cadastrado e salvo com sucesso!");
            }
            case 2 -> hospedeService.listarHospedes();
            case 3 -> {
                String cpf = Utils.lerString("CPF do hóspede a remover: ");
                if (hospedeService.removerHospede(cpf)) {
                    System.out.println("Hóspede removido com sucesso!");
                } else {
                    System.out.println("Hóspede não encontrado.");
                }
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    // --- Gerenciar Quartos ---
    public void gerenciarQuartos() {
        int escolha = Utils.lerInt("\n1-Cadastrar\n2-Listar\n3-Remover\nEscolha: ");

        switch (escolha) {
            case 1 -> {
                int numero = Utils.lerInt("Número do quarto: ");
                String tipo = Utils.lerString("Tipo do quarto: ");
                double valor = Utils.lerDouble("Valor da diária: ");

                Quarto q = new Quarto();
                q.setNumero(numero);
                q.setTipo(tipo);
                q.setValorDiaria(valor);
                q.setDisponivel(true);

                quartoService.adicionarQuarto(q);
                System.out.println("Quarto cadastrado e salvo com sucesso!");
            }
            case 2 -> {
                System.out.println("\n--- Lista de Quartos ---");
                for (Quarto q : quartoService.listarQuartos()) {
                    System.out.println(q);
                }
            }
            case 3 -> {
                int numero = Utils.lerInt("Número do quarto a remover: ");
                if (quartoService.removerQuarto(numero)) {
                    System.out.println("Quarto removido com sucesso!");
                } else {
                    System.out.println("Quarto não encontrado.");
                }
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    // --- Gerenciar Reservas ---
    public void gerenciarReservas() {
        int escolha = Utils.lerInt("\n1-Criar\n2-Listar\n3-Cancelar\nEscolha: ");

        switch (escolha) {
            case 1 -> {
                String cpfHospede = Utils.lerString("CPF do hóspede: ");
                Hospede hospede = hospedeService.buscarPorCpf(cpfHospede);
                if (hospede == null) {
                    System.out.println("Hóspede não encontrado!");
                    return;
                }

                int numeroQuarto = Utils.lerInt("Número do quarto: ");
                Quarto quarto = quartoService.buscarPorNumero(numeroQuarto);
                if (quarto == null) {
                    System.out.println("Quarto não encontrado!");
                    return;
                }
                if (!quarto.isDisponivel()) {
                    System.out.println("Quarto indisponível!");
                    return;
                }

                String dataEntrada = Utils.lerString("Data de entrada (dd/mm/yyyy): ");
                String dataSaida = Utils.lerString("Data de saída (dd/mm/yyyy): ");
                int dias = Utils.lerInt("Número de dias: ");

                reservaService.criarReserva(hospede, quarto, dataEntrada, dataSaida, dias);
                quarto.setDisponivel(false);
                quartoService.salvarArquivo(); // atualizar disponibilidade
                System.out.println("Reserva criada e salva com sucesso!");
            }
            case 2 -> {
                System.out.println("\n--- Lista de Reservas ---");
                for (Reserva r : reservaService.listarReservas()) {
                    System.out.println(r);
                }
            }
            case 3 -> {
                String cpfHospede = Utils.lerString("CPF do hóspede para cancelar: ");
                Reserva r = reservaService.buscarPorHospede(cpfHospede);
                if (r != null) {
                    reservaService.cancelarReserva(cpfHospede);
                    Quarto quarto = r.getQuarto();
                    if (quarto != null) {
                        quarto.setDisponivel(true);
                        quartoService.salvarArquivo(); // atualizar disponibilidade
                    }
                    System.out.println("Reserva cancelada e arquivo atualizado!");
                } else {
                    System.out.println("Reserva não encontrada.");
                }
            }
            default -> System.out.println("Opção inválida!");
        }
    }
}
