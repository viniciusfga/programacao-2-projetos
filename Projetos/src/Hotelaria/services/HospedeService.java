package Hotelaria.services;

import Hotelaria.models.Hospede;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeService {

    private List<Hospede> hospedes = new ArrayList<>();
    private final String arquivo = "Projetos/data/hospedes.txt"; // arquivo no projeto

    // Adicionar hóspede
    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
        System.out.println("Hóspede adicionado com sucesso!");
    }

    // Listar hóspedes
    public void listarHospedes() {
        if (hospedes.isEmpty()) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Hóspedes ---");
        for (Hospede h : hospedes) {
            System.out.println(h.toString());
        }
    }

    // Buscar hóspede por CPF
    public Hospede buscarPorCpf(String cpf) {
        for (Hospede h : hospedes) {
            if (h.getCpf().equalsIgnoreCase(cpf)) {
                return h;
            }
        }
        return null; // se não encontrar
    }

    // Remover hóspede
    public boolean removerHospede(String cpf) {
        Hospede encontrado = buscarPorCpf(cpf);
        if (encontrado != null) {
            hospedes.remove(encontrado);
            System.out.println("Hóspede removido com sucesso!");
            return true;
        } else {
            System.out.println("Hóspede não encontrado.");
            return false;
        }
    }

    // Editar hóspede (atualizar dados)
    public boolean editarHospede(String cpf, Hospede novosDados) {
        Hospede existente = buscarPorCpf(cpf);
        if (existente != null) {
            existente.setNome(novosDados.getNome());
            existente.setEmail(novosDados.getEmail());
            existente.setCelular(novosDados.getCelular());
            existente.setProfissao(novosDados.getProfissao());
            existente.setGenero(novosDados.getGenero());
            existente.setNacionalidade(novosDados.getNacionalidade());
            System.out.println("Dados do hóspede atualizados com sucesso!");
            return true;
        } else {
            System.out.println("Hóspede não encontrado.");
            return false;
        }
    }

    // Retornar lista completa (para outros serviços)
    public List<Hospede> getHospedes() {
        return hospedes;
    }

    // ---------------------- ARQUIVO ----------------------

    public void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Hospede h : hospedes) {
                bw.write(h.getNome() + ";" + h.getCpf() + ";" + h.getRg() + ";" + h.getCelular() + ";" + h.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar hóspedes: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        hospedes.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 5) {
                    Hospede h = new Hospede();
                    h.setNome(dados[0]);
                    h.setCpf(dados[1]);
                    h.setRg(dados[2]);
                    h.setCelular(dados[3]);
                    h.setEmail(dados[4]);
                    hospedes.add(h);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar hóspedes: " + e.getMessage());
        }
    }

}
