package HotelariaFace.services;

import Hotelaria.Utils;

import java.io.*;
import java.util.Scanner;

public class ReservaService {

    private final String arquivoReservas = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "reservas.txt";

    public ReservaService() {
        inicializarArquivo();
    }

    // Garante que o arquivo exista
    private void inicializarArquivo() {
        try {
            File dataDir = new File(arquivoReservas).getParentFile();
            if (!dataDir.exists()) dataDir.mkdirs();

            File arq = new File(arquivoReservas);
            if (!arq.exists()) arq.createNewFile();
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo de reservas: " + e.getMessage());
        }
    }

    // Criar nova reserva
    public void criarReserva() {
        System.out.println("\n--- Criar Reserva ---");

        String cpfHospede = Utils.lerString("CPF do hóspede: ");
        int numeroQuarto = Utils.lerInt("Número do quarto: ");
        String dataEntrada = Utils.lerString("Data de entrada (dd/mm/aaaa): ");
        String dataSaida = Utils.lerString("Data de saída (dd/mm/aaaa): ");
        double valorTotal = Utils.lerDouble("Valor total da reserva: ");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoReservas, true))) {
            bw.write(cpfHospede + ";" + numeroQuarto + ";" + dataEntrada + ";" + dataSaida + ";" + valorTotal);
            bw.newLine();
            System.out.println("\nReserva cadastrada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar reserva: " + e.getMessage());
        }
    }

    // Listar todas as reservas
    public void listarReservas() {
        File f = new File(arquivoReservas);

        if (f.length() == 0) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            System.out.println("\n=== Lista de Reservas ===");
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) {
                    System.out.println("\nHóspede (CPF): " + dados[0]);
                    System.out.println("Quarto nº: " + dados[1]);
                    System.out.println("Entrada: " + dados[2]);
                    System.out.println("Saída: " + dados[3]);
                    System.out.println("Valor total: R$ " + dados[4]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }
    }

    // Cancelar uma reserva (buscando pelo CPF do hóspede)
    public void cancelarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o CPF do hóspede para cancelar reserva: ");
        String cpfCancelar = sc.nextLine();

        File arquivo = new File(arquivoReservas);
        File temp = new File(arquivo.getParent(), "temp.txt");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (!dados[0].equalsIgnoreCase(cpfCancelar)) {
                    bw.write(linha);
                    bw.newLine();
                } else {
                    encontrado = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao cancelar reserva: " + e.getMessage());
        }

        if (arquivo.delete() && temp.renameTo(arquivo)) {
            if (encontrado)
                System.out.println("Reserva cancelada com sucesso!");
            else
                System.out.println("Nenhuma reserva encontrada para o CPF informado!");
        }
    }

    // Apagar todas as reservas
    public void apagarTodas() {
        File f = new File(arquivoReservas);
        if (f.exists()) {
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.print("");
                System.out.println("Todas as reservas foram apagadas!");
            } catch (IOException e) {
                System.out.println("Erro ao apagar reservas: " + e.getMessage());
            }
        }
    }
}
