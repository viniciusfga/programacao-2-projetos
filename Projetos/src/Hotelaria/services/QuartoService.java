package Hotelaria.services;

import java.io.*;
import java.util.Scanner;
import Hotelaria.Utils;

public class QuartoService {

    private final String arquivoQuartos = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "quartos.txt";

    private final String arquivoId = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "idQuarto.txt";

    public QuartoService() {
        inicializarArquivos();
    }

    private void inicializarArquivos() {
        try {
            File dataDir = new File(arquivoQuartos).getParentFile();
            if (!dataDir.exists()) dataDir.mkdirs();

            File arqQuartos = new File(arquivoQuartos);
            if (!arqQuartos.exists()) arqQuartos.createNewFile();

            File arqId = new File(arquivoId);
            if (!arqId.exists()) gravaId(1);

        } catch (IOException e) {
            System.out.println("Erro ao criar arquivos: " + e.getMessage());
        }
    }

    private int lerId() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoId))) {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            return 1;
        }
    }

    private void gravaId(int id) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoId))) {
            pw.println(id);
        } catch (IOException e) {
            System.out.println("Erro ao gravar ID: " + e.getMessage());
        }
    }

    public void cadastrarQuarto() {
        int numero = lerId();

        System.out.println("\n--- Cadastro de Quarto ---");
        String tipo = Utils.lerString("Tipo (Simples / Duplo / Luxo): ");
        double valor = Utils.lerDouble("Valor da diária: ");
        boolean disponivel = true;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoQuartos, true))) {
            bw.write(numero + ";" + tipo + ";" + valor + ";" + disponivel);
            bw.newLine();
            System.out.println("\nQuarto cadastrado com sucesso!");
            gravaId(numero + 1);
        } catch (IOException e) {
            System.out.println("Erro ao gravar quarto: " + e.getMessage());
        }
    }

    public void listarQuartos() {
        File f = new File(arquivoQuartos);

        if (f.length() == 0) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            System.out.println("\n=== Lista de Quartos ===");
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 4) {
                    System.out.println("\nNúmero: " + dados[0]);
                    System.out.println("Tipo: " + dados[1]);
                    System.out.println("Valor diária: R$ " + dados[2]);
                    System.out.println("Disponível: " + dados[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler quartos: " + e.getMessage());
        }
    }

    public void removerQuarto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número do quarto para remover: ");
        int numeroRemover = sc.nextInt();

        File arquivo = new File(arquivoQuartos);
        File temp = new File(arquivo.getParent(), "temp.txt");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int numero = Integer.parseInt(dados[0]);
                if (numero != numeroRemover) {
                    bw.write(linha);
                    bw.newLine();
                } else {
                    encontrado = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao remover quarto: " + e.getMessage());
        }

        if (arquivo.delete() && temp.renameTo(arquivo)) {
            if (encontrado)
                System.out.println("Quarto removido com sucesso!");
            else
                System.out.println("⚠Quarto não encontrado!");
        }
    }

    public void apagarTodos() {
        File f = new File(arquivoQuartos);
        if (f.exists()) {
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.print("");
                gravaId(1);
                System.out.println("Todos os quartos foram apagados!");
            } catch (IOException e) {
                System.out.println("Erro ao apagar quartos: " + e.getMessage());
            }
        }
    }

    // BUSCAR HOSPEDE
    public void buscarQuarto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Buscar Quarto ===");
        System.out.println("1 - Buscar por Número");
        System.out.print("Escolha uma opção: ");

        int opcao = sc.nextInt();
        sc.nextLine(); // limpar buffer

        File f = new File(arquivoQuartos);

        if (f.length() == 0) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String linha;

            switch (opcao) {

                // 🔍 BUSCAR POR NÚMERO DO QUARTO
                case 1:
                    System.out.print("Digite o número do quarto: ");
                    int numeroBuscar = sc.nextInt();
                    sc.nextLine();

                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");

                        if (Integer.parseInt(dados[0]) == numeroBuscar) {
                            encontrado = true;

                            System.out.println("\n--- Quarto Encontrado ---");
                            System.out.println("Número: " + dados[0]);
                            System.out.println("Tipo: " + dados[1]);
                            System.out.println("Valor diária: R$ " + dados[2]);
                            System.out.println("Disponível: " + dados[3]);
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    return;
            }

        } catch (IOException e) {
            System.out.println("Erro ao buscar quarto: " + e.getMessage());
        }

        if (!encontrado) {
            System.out.println("\n⚠ Nenhum quarto encontrado!");
        }
    }
}
