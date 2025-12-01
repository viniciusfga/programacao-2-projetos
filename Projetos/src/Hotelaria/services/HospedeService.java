package Hotelaria.services;

import java.io.*;
import java.util.Scanner;

import Hotelaria.Utils;

public class HospedeService {

    // CAMINHO BASE: programacao-2-projetos/projetos/src/Hotelaria/data/hospedes.txt
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

    // LÊ O ÚLTIMO ID SALVO
    private int lerId() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoId))) {
            return Integer.parseInt(br.readLine());
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

        if (f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            System.out.println("\n=== Lista de Hóspedes ===");
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 6) {
                    System.out.println("\nID: " + dados[0]);
                    System.out.println("Nome: " + dados[1]);
                    System.out.println("CPF: " + dados[2]);
                    System.out.println("RG: " + dados[3]);
                    System.out.println("Celular: " + dados[4]);
                    System.out.println("Email: " + dados[5]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler hóspedes: " + e.getMessage());
        }
    }

    // REMOVER HOSPEDE POR ID
    public void removerHospede() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do hóspede para remover: ");
        int idRemover = sc.nextInt();

        File arquivo = new File(arquivoHospedes);
        File temp = new File(arquivo.getParent(), "temp.txt");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
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
        }

        if (arquivo.delete() && temp.renameTo(arquivo)) {
            if (encontrado)
                System.out.println("Hóspede removido com sucesso!");
            else
                System.out.println("Hóspede não encontrado!");
        }
    }

    // APAGAR TODOS
    public void apagarTodos() {
        File f = new File(arquivoHospedes);
        if (f.exists()) {
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.print(""); // limpa o conteúdo
                gravaId(0);
                System.out.println("🗑Todos os hóspedes foram apagados!");
            } catch (IOException e) {
                System.out.println("Erro ao apagar hóspedes: " + e.getMessage());
            }
        }
    }

    // BUSCAR HOSPEDE
    public void buscarHospede() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Buscar Hóspede ===");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar por Nome");
        System.out.print("Escolha uma opção: ");

        int opcao = sc.nextInt();
        sc.nextLine(); // limpar buffer

        File f = new File(arquivoHospedes);

        if (f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String linha;

            switch (opcao) {

                // BUSCAR POR ID
                case 1:
                    System.out.print("Digite o ID: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");

                        if (Integer.parseInt(dados[0]) == idBuscar) {
                            encontrado = true;
                            System.out.println("\n--- Hóspede Encontrado ---");
                            System.out.println("ID: " + dados[0]);
                            System.out.println("Nome: " + dados[1]);
                            System.out.println("CPF: " + dados[2]);
                            System.out.println("RG: " + dados[3]);
                            System.out.println("Celular: " + dados[4]);
                            System.out.println("Email: " + dados[5]);
                            break;
                        }
                    }
                    break;

                // BUSCAR POR NOME (parcial ou completo)
                case 2:
                    System.out.print("Digite o nome ou parte do nome: ");
                    String nomeBuscar = sc.nextLine().toLowerCase();

                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");
                        String nome = dados[1].toLowerCase();

                        if (nome.contains(nomeBuscar)) {
                            encontrado = true;
                            System.out.println("\n--- Hóspede Encontrado ---");
                            System.out.println("ID: " + dados[0]);
                            System.out.println("Nome: " + dados[1]);
                            System.out.println("CPF: " + dados[2]);
                            System.out.println("RG: " + dados[3]);
                            System.out.println("Celular: " + dados[4]);
                            System.out.println("Email: " + dados[5]);
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
}
