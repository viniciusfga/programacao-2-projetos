package Hotelaria.services;

import Hotelaria.Utils;
import Hotelaria.models.Hospede;

import java.io.*;

public class HospedeService {

    private final String arquivoHospedes = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "hospedes.txt";

    public HospedeService() {
        inicializarArquivoHospedes();
    }

    private void inicializarArquivoHospedes() {
        try {
            File dir = new File(arquivoHospedes).getParentFile();
            if (!dir.exists()) dir.mkdirs();

            File hosp = new File(arquivoHospedes);
            if (!hosp.exists()) hosp.createNewFile();

        } catch (IOException e) {
            System.out.println("Erro ao criar diretórios: " + e.getMessage());
        }
    }

    // Lê o último ID usado no arquivo e retorna o próximo
    private int gerarProximoId() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0)
            return 1;  // se o arquivo está vazio, primeiro ID = 1

        int ultimoId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 1) {
                    ultimoId = Integer.parseInt(dados[0]); // pega o ID da linha
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao gerar ID: " + e.getMessage());
            return 1;
        }

        return ultimoId + 1; // próximo ID
    }

    private String hospedeParaLinha(Hospede h) {
        return h.id + ";" + h.nome + ";" + h.cpf + ";" + h.rg + ";" + h.celular + ";" + h.email;
    }

    private Hospede linhaParaHospede(String linha) {
        String[] d = linha.split(";");
        if (d.length < 6) return null;

        return new Hospede(
                Integer.parseInt(d[0]),
                d[1], d[2], d[3], d[4], d[5]
        );
    }

    // Cadastrar
    public void cadastrarHospede() {
        int id = gerarProximoId(); // gera ID automático

        System.out.println("\n--- Cadastro de Hóspede ---");

        String nome = Utils.lerString("Nome: ");
        String cpf = Utils.lerString("CPF: ");
        String rg = Utils.lerString("RG: ");
        String celular = Utils.lerString("Celular: ");
        String email = Utils.lerString("E-mail: ");

        Hospede h = new Hospede(id, nome, cpf, rg, celular, email);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoHospedes, true))) {
            bw.write(hospedeParaLinha(h));
            bw.newLine();
            System.out.println("\nHóspede cadastrado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao gravar hóspede: " + e.getMessage());
        }
    }

    // Listar
    public void listarHospedes() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Hóspedes ===");

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                Hospede h = linhaParaHospede(linha);
                if (h == null) continue;

                exibirHospede(h);
                System.out.println("------------------------");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler hóspedes: " + e.getMessage());
        }
    }

    // Remover
    public void removerHospede() {
        File arquivo = new File(arquivoHospedes);

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        int idRemover = Utils.lerInt("Digite o ID para remover: ");

        File temp = new File(arquivo.getParent(), "temp.txt");
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                Hospede h = linhaParaHospede(linha);
                if (h == null) continue;

                if (h.id != idRemover) {
                    bw.write(hospedeParaLinha(h));
                    bw.newLine();
                } else {
                    encontrado = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
            return;
        }

        arquivo.delete();
        temp.renameTo(arquivo);

        if (encontrado)
            System.out.println("Hóspede removido com sucesso!");
        else
            System.out.println("Hóspede não encontrado!");
    }

    // Apagar todos
    public void apagarTodos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoHospedes))) {
            pw.print("");
            System.out.println("Todos os hóspedes foram apagados!");
        } catch (IOException e) {
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
    }

    // Buscar
    public void buscarHospede() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.println("\n=== Buscar Hóspede ===");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar por Nome");

        int opcao = Utils.lerInt("Escolha: ");
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;

            switch (opcao) {
                case 1:
                    int idBuscar = Utils.lerInt("Digite o ID: ");

                    while ((linha = br.readLine()) != null) {
                        Hospede h = linhaParaHospede(linha);
                        if (h == null) continue;

                        if (h.id == idBuscar) {
                            exibirHospede(h);
                            encontrado = true;
                            break;
                        }
                    }
                    break;

                case 2:
                    String nomeBuscar = Utils.lerString("Parte do nome: ").toLowerCase();

                    while ((linha = br.readLine()) != null) {
                        Hospede h = linhaParaHospede(linha);
                        if (h == null) continue;

                        if (h.nome.toLowerCase().contains(nomeBuscar)) {
                            exibirHospede(h);
                            encontrado = true;
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    return;
            }

        } catch (IOException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        if (!encontrado)
            System.out.println("Nenhum hóspede encontrado!");
    }

    private void exibirHospede(Hospede h) {
        System.out.println("\nID: " + h.id);
        System.out.println("Nome: " + h.nome);
        System.out.println("CPF: " + h.cpf);
        System.out.println("RG: " + h.rg);
        System.out.println("Celular: " + h.celular);
        System.out.println("Email: " + h.email);
    }

    public void atualizarHospede() {
        File arquivo = new File(arquivoHospedes);

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        int id = Utils.lerInt("Digite o ID do hóspede que deseja atualizar: ");

        Hospede atual = null;

        // Primeiro, localizar o hóspede
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                Hospede h = linhaParaHospede(linha);
                if (h != null && h.id == id) {
                    atual = h;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler hóspedes: " + e.getMessage());
            return;
        }

        if (atual == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }

        System.out.println("\n=== Hóspede Atual ===");
        exibirHospede(atual);

        System.out.println("\nDigite os novos dados (ENTER para manter o atual):");

        String novoNome = Utils.lerString("Nome (" + atual.nome + "): ");
        String novoCPF = Utils.lerString("CPF (" + atual.cpf + "): ");
        String novoRG   = Utils.lerString("RG (" + atual.rg + "): ");
        String novoCel  = Utils.lerString("Celular (" + atual.celular + "): ");
        String novoEmail= Utils.lerString("Email (" + atual.email + "): ");

        // Mantém valores se o usuário deixar vazio
        Hospede atualizado = new Hospede(
                atual.id,
                novoNome.isEmpty() ? atual.nome : novoNome,
                novoCPF.isEmpty() ? atual.cpf : novoCPF,
                novoRG.isEmpty() ? atual.rg : novoRG,
                novoCel.isEmpty() ? atual.celular : novoCel,
                novoEmail.isEmpty() ? atual.email : novoEmail
        );

        // Atualizar arquivo
        File temp = new File(arquivo.getParent(), "temp_hospedes.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                Hospede h = linhaParaHospede(linha);

                if (h == null) continue;

                if (h.id == atualizado.id) {
                    bw.write(hospedeParaLinha(atualizado));
                } else {
                    bw.write(hospedeParaLinha(h));
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao atualizar hóspede: " + e.getMessage());
            return;
        }

        arquivo.delete();
        temp.renameTo(arquivo);

        System.out.println("\nHóspede atualizado com sucesso!");
    }

}
