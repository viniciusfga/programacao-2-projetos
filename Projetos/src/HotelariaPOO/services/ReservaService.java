package HotelariaPOO.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import HotelariaPOO.models.Reserva;
import HotelariaPOO.models.Hospede;
import HotelariaPOO.models.Quarto;

public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();
    private final String arquivo = "Projetos/data/reservas.txt";

    // Criar uma nova reserva
    public void criarReserva(Hospede hospede, Quarto quarto, String dataEntrada, String dataSaida, int dias) {
        Reserva reserva = new Reserva();
        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);
        reserva.setDataEntrada(dataEntrada);
        reserva.setDataSaida(dataSaida);
        reserva.setValorTotal(quarto.getValorDiaria() * dias);
        reservas.add(reserva);
        salvarArquivo(); // <- grava imediatamente no arquivo
        System.out.println("Reserva criada com sucesso!");
    }

    // Listar todas as reservas
    public List<Reserva> listarReservas() {
        return reservas;
    }

    // Buscar reserva por hóspede
    public Reserva buscarPorHospede(String nomeHospede) {
        for (Reserva r : reservas) {
            if (r.getHospede().getNome().equalsIgnoreCase(nomeHospede)) {
                return r;
            }
        }
        return null;
    }

    // Cancelar uma reserva
    public boolean cancelarReserva(String nomeHospede) {
        Reserva reserva = buscarPorHospede(nomeHospede);
        if (reserva != null) {
            reservas.remove(reserva);
            if (reserva.getQuarto() != null) {
                reserva.getQuarto().setDisponivel(true); // liberar o quarto
            }
            salvarArquivo(); // <- atualiza o arquivo
            System.out.println("Reserva cancelada com sucesso!");
            return true;
        }
        System.out.println("Reserva não encontrada.");
        return false;
    }
    // ---------------------- ARQUIVO ----------------------

    // ---------------------- ARQUIVO ----------------------

    public void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Reserva r : reservas) {
                bw.write(r.getHospede().getCpf() + ";" +
                        r.getQuarto().getNumero() + ";" +
                        r.getDataEntrada() + ";" +
                        r.getDataSaida() + ";" +
                        r.getValorTotal());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar reservas: " + e.getMessage());
        }
    }

    public void carregarArquivo(HospedeService hospedeService, QuartoService quartoService) {
        reservas.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) {
                    String cpfHospede = dados[0];
                    int numeroQuarto = Integer.parseInt(dados[1]);
                    String dataEntrada = dados[2];
                    String dataSaida = dados[3];
                    double valorTotal = Double.parseDouble(dados[4]);

                    Hospede h = hospedeService.buscarPorCpf(cpfHospede);
                    Quarto q = quartoService.buscarPorNumero(numeroQuarto);
                    if (h != null && q != null) {
                        Reserva r = new Reserva();
                        r.setHospede(h);
                        r.setQuarto(q);
                        r.setDataEntrada(dataEntrada);
                        r.setDataSaida(dataSaida);
                        r.setValorTotal(valorTotal);
                        reservas.add(r);
                        q.setDisponivel(false); // quarto ocupado
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar reservas: " + e.getMessage());
        }
    }
}
