package Hotelaria.services;

import Hotelaria.models.Reserva;
import Hotelaria.Utils;

import java.io.*;
import java.util.*;

public class ReservaService {

    private final String arquivoReservas = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "reservas.txt";

    private final QuartoService quartoService = new QuartoService();

    public ReservaService() {
        inicializarArquivo();
    }

    private void inicializarArquivo() {
        try {
            File dir = new File(arquivoReservas).getParentFile();
            if (!dir.exists()) dir.mkdirs();

            File arq = new File(arquivoReservas);
            if (!arq.exists()) arq.createNewFile();
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo de reservas: " + e.getMessage());
        }
    }

    private String reservaParaLinha(Reserva r) {
        return r.cpfHospede + ";" +
                r.numeroQuarto + ";" +
                r.dataEntrada + ";" +
                r.dataSaida + ";" +
                r.valorTotal;
    }

    private Reserva parse(String linha) {
        String[] d = linha.split(";");
        if (d.length != 5) return null;

        return new Reserva(
                d[0],
                Integer.parseInt(d[1]),
                d[2],
                d[3],
                Double.parseDouble(d[4])
        );
    }

    private List<Reserva> carregarTodas() {
        List<Reserva> lista = new ArrayList<>();
        File arquivo = new File(arquivoReservas);

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Reserva r = parse(linha);
                if (r != null) lista.add(r);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler reservas: " + e.getMessage());
        }

        return lista;
    }

    private void salvarTodas(List<Reserva> reservas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoReservas))) {
            for (Reserva r : reservas) {
                bw.write(reservaParaLinha(r));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar reservas: " + e.getMessage());
        }
    }

    public void criarReserva() {
        System.out.println("\n--- Criar Reserva ---");

        String cpf = Utils.lerString("CPF do hóspede: ");
        int numero = Utils.lerInt("Número do quarto: ");

        var quarto = quartoService.buscarPorNumero(numero);
        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        if (!quarto.disponivel) {
            System.out.println("Este quarto está ocupado.");
            return;
        }

        String entrada = Utils.lerString("Data de entrada (dd/mm/aaaa): ");
        String saida = Utils.lerString("Data de saída (dd/mm/aaaa): ");
        double valor = Utils.lerDouble("Valor total da reserva: ");

        Reserva r = new Reserva(cpf, numero, entrada, saida, valor);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoReservas, true))) {
            bw.write(reservaParaLinha(r));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar reserva: " + e.getMessage());
            return;
        }

        quarto.disponivel = false;
        quartoService.atualizarQuarto(quarto);

        System.out.println("Reserva cadastrada e quarto atualizado como ocupado.");
    }

    public void listarReservas() {
        List<Reserva> lista = carregarTodas();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }

        System.out.println("\n=== Lista de Reservas ===");
        for (Reserva r : lista) {
            System.out.println("\nCPF: " + r.cpfHospede);
            System.out.println("Quarto: " + r.numeroQuarto);
            System.out.println("Entrada: " + r.dataEntrada);
            System.out.println("Saída: " + r.dataSaida);
            System.out.println("Valor: R$ " + r.valorTotal);
        }
    }

    // CANCELAR RESERVA E LIBERAR O QUARTO
    public void cancelarReserva() {
        String cpf = Utils.lerString("Digite o CPF para cancelar: ");

        List<Reserva> lista = carregarTodas();
        int antes = lista.size();

        Reserva reservaRemovida = null;

        for (Reserva r : lista) {
            if (r.cpfHospede.equalsIgnoreCase(cpf)) {
                reservaRemovida = r;
                break;
            }
        }

        if (reservaRemovida == null) {
            System.out.println("Nenhuma reserva encontrada para este CPF.");
            return;
        }

        lista.remove(reservaRemovida);
        salvarTodas(lista);

        // Liberar o quarto
        var quarto = quartoService.buscarPorNumero(reservaRemovida.numeroQuarto);
        if (quarto != null) {
            quarto.disponivel = true;
            quartoService.atualizarQuarto(quarto);
        }

        System.out.println("Reserva cancelada e quarto liberado.");
    }

    public void buscarReserva() {
        String cpf = Utils.lerString("CPF para buscar: ");

        List<Reserva> lista = carregarTodas();
        boolean encontrou = false;

        for (Reserva r : lista) {
            if (r.cpfHospede.equalsIgnoreCase(cpf)) {
                System.out.println("\n=== Reserva Encontrada ===");
                System.out.println("CPF: " + r.cpfHospede);
                System.out.println("Quarto: " + r.numeroQuarto);
                System.out.println("Entrada: " + r.dataEntrada);
                System.out.println("Saída: " + r.dataSaida);
                System.out.println("Valor: " + r.valorTotal);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada para este CPF.");
        }
    }

    public void apagarTodas() {
        try (PrintWriter pw = new PrintWriter(arquivoReservas)) {
            pw.print("");
        } catch (IOException e) {
            System.out.println("Erro ao apagar: " + e.getMessage());
            return;
        }

        System.out.println("Todas as reservas foram apagadas.");
    }
}
