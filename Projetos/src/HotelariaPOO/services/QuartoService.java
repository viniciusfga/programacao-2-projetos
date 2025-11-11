package HotelariaPOO.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import HotelariaPOO.models.Quarto;

public class QuartoService {

    private List<Quarto> quartos = new ArrayList<>();
    private final String arquivo = "Projetos/data/quartos.txt";

    // Adiciona um novo quarto
    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
        salvarArquivo(); // garante que o arquivo seja atualizado
        System.out.println("Quarto adicionado com sucesso!");
    }

    // Lista todos os quartos
    public List<Quarto> listarQuartos() {
        return quartos;
    }

    // Busca um quarto pelo número
    public Quarto buscarPorNumero(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null; // se não encontrar
    }

    // Remove um quarto pelo número
    public boolean removerQuarto(int numero) {
        Quarto quarto = buscarPorNumero(numero);
        if (quarto != null) {
            quartos.remove(quarto);
            salvarArquivo(); // atualiza o arquivo
            System.out.println("Quarto removido com sucesso!");
            return true;
        }
        System.out.println("Quarto não encontrado.");
        return false;
    }
    // ---------------------- ARQUIVO ----------------------

    public void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Quarto q : quartos) {
                bw.write(q.getNumero() + ";" + q.getTipo() + ";" + q.getValorDiaria() + ";" + q.isDisponivel());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar quartos: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        quartos.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 4) {
                    Quarto q = new Quarto();
                    q.setNumero(Integer.parseInt(dados[0]));
                    q.setTipo(dados[1]);
                    q.setValorDiaria(Double.parseDouble(dados[2]));
                    q.setDisponivel(Boolean.parseBoolean(dados[3]));
                    quartos.add(q);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar quartos: " + e.getMessage());
        }
    }
}
