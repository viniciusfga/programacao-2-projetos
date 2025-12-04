package Hotelaria.services;

import Hotelaria.Utils;

import java.io.*;
import java.util.Scanner;

public class HospedeService {

    // SCANNER ÚNICO (evita vazamento)
    private static final Scanner sc = new Scanner(System.in);

    // CAMINHO BASE
    private final String arquivoHospedes = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "hospedes.txt";

    private final String arquivoId = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "idHospede.txt";

    public HospedeService() {
        inicializarArquivos();
    }

    // GARANTE QUE OS ARQUIVOS EXISTAM
    private void inicializarArquivos() {
        try {
            File dataDir = new File(arquivoHospedes).getParentFile();
            if (!dataDir.exists()) dataDir.mkdirs();

            File arqHospedes = new File(arquivoHospedes);
            if (!arqHospedes.exists()) arqHospedes.createNewFile();

            File arqId = new File(arquivoId);
            if (!arqId.exists()) gravaId(0);

        } catch (IOException e) {
            System.out.println("Erro ao criar diretórios: " + e.getMessage());
        }
    }

    // LÊ O ÚLTIMO ID SALVO (BLINDADO)
    private int lerId() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoId))) {
            String linha = br.readLine();
            if (linha == null || linha.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(linha.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    // GRAVA O NOVO ID
    private void gravaId(int id) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoId))) {
            pw.println(id);
        } catch (IOException e) {
            System.out.println("Erro ao gravar ID: " + e.getMessage());
        }
    }

    // CADASTRAR
    public void cadastrarHospede() {
        int id = lerId();

        System.out.println("\n--- Cadastro de Hóspede ---");
        String nome = Utils.lerString("Nome: ");
        String cpf = Utils.lerString("CPF: ");
        String rg = Utils.lerString("RG: ");
        String celular = Utils.lerString("Celular: ");
        String email = Utils.lerString("E-mail: ");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoHospedes, true))) {
            bw.write(id + ";" + nome + ";" + cpf + ";" + rg + ";" + celular + ";" + email);
            bw.newLine();
            System.out.println("\nHóspede cadastrado com sucesso!");
            gravaId(id + 1);
        } catch (IOException e) {
            System.out.println("Erro ao gravar hóspede: " + e.getMessage());
        }
    }

    // LISTAR TODOS
    public void listarHospedes() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            System.out.println("\n=== Lista de Hóspedes ===");
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length < 6) continue;

                System.out.println("\nID: " + dados[0]);
                System.out.println("Nome: " + dados[1]);
                System.out.println("CPF: " + dados[2]);
                System.out.println("RG: " + dados[3]);
                System.out.println("Celular: " + dados[4]);
                System.out.println("Email: " + dados[5]);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler hóspedes: " + e.getMessage());
        }
    }

    // REMOVER HOSPEDE POR ID (BLINDADO)
    public void removerHospede() {
        File arquivo = new File(arquivoHospedes);

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.print("Digite o ID do hóspede para remover: ");
        int idRemover = sc.nextInt();
        sc.nextLine();

        File temp = new File(arquivo.getParent(), "temp.txt");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length < 6) continue;

                int id = Integer.parseInt(dados[0]);

                if (id != idRemover) {
                    bw.write(linha);
                    bw.newLine();
                } else {
                    encontrado = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao remover hóspede: " + e.getMessage());
            return;
        }

        if (arquivo.delete()) {
            if (temp.renameTo(arquivo)) {
                if (encontrado)
                    System.out.println("Hóspede removido com sucesso!");
                else
                    System.out.println("Hóspede não encontrado!");
            } else {
                System.out.println("Erro ao restaurar arquivo!");
            }
        }
    }

    // APAGAR TODOS
    public void apagarTodos() {
        File f = new File(arquivoHospedes);

        if (!f.exists()) {
            System.out.println("Arquivo não encontrado.");
            return;
        }

        try (PrintWriter pw = new PrintWriter(f)) {
            pw.print("");
            gravaId(0); // para projeto acadêmico
            System.out.println("🗑 Todos os hóspedes foram apagados!");
        } catch (IOException e) {
            System.out.println("Erro ao apagar hóspedes: " + e.getMessage());
        }
    }

    // BUSCAR HOSPEDE
    public void buscarHospede() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.println("\n=== Buscar Hóspede ===");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar por Nome");
        System.out.print("Escolha uma opção: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String linha;

            switch (opcao) {

                case 1:
                    System.out.print("Digite o ID: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");

                        if (dados.length < 6) continue;

                        if (Integer.parseInt(dados[0]) == idBuscar) {
                            encontrado = true;
                            exibirHospede(dados);
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome ou parte do nome: ");
                    String nomeBuscar = sc.nextLine().toLowerCase();

                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");

                        if (dados.length < 6) continue;

                        if (dados[1].toLowerCase().contains(nomeBuscar)) {
                            encontrado = true;
                            exibirHospede(dados);
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    return;
            }

        } catch (IOException e) {
            System.out.println("Erro ao buscar hóspede: " + e.getMessage());
        }

        if (!encontrado) {
            System.out.println("Nenhum hóspede encontrado!");
        }
    }

    // MÉTODO AUXILIAR DE EXIBIÇÃO
    private void exibirHospede(String[] dados) {
        System.out.println("\n--- Hóspede Encontrado ---");
        System.out.println("ID: " + dados[0]);
        System.out.println("Nome: " + dados[1]);
        System.out.println("CPF: " + dados[2]);
        System.out.println("RG: " + dados[3]);
        System.out.println("Celular: " + dados[4]);
        System.out.println("Email: " + dados[5]);
    }
}
