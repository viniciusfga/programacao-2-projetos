package Hotelaria.services;

import Hotelaria.Utils;
import Hotelaria.models.Quarto;

import java.io.*;

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

    // Auxiliar: transforma linha em objeto Quarto
    private Quarto linhaParaQuarto(String linha) {
        String[] d = linha.split(";");
        return new Quarto(
                Integer.parseInt(d[0]),
                d[1],
                Double.parseDouble(d[2]),
                Boolean.parseBoolean(d[3])
        );
    }

    // Auxiliar: transforma objeto Quarto em linha
    private String quartoParaLinha(Quarto q) {
        return q.numero + ";" + q.tipo + ";" + q.valorDiaria + ";" + q.disponivel;
    }

    public void cadastrarQuarto() {
        int numero = lerId();

        System.out.println("\n--- Cadastro de Quarto ---");
        String tipo = Utils.lerString("Tipo (Simples / Duplo / Luxo): ");
        double valor = Utils.lerDouble("Valor da diária: ");

        Quarto q = new Quarto(numero, tipo, valor, true);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoQuartos, true))) {
            bw.write(quartoParaLinha(q));
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
                Quarto q = linhaParaQuarto(linha);

                System.out.println("\nNúmero: " + q.numero);
                System.out.println("Tipo: " + q.tipo);
                System.out.println("Valor diária: R$ " + q.valorDiaria);
                System.out.println("Disponível: " + q.disponivel);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler quartos: " + e.getMessage());
        }
    }

    public void removerQuarto() {
        int numeroRemover = Utils.lerInt("Digite o número do quarto para remover: ");

        File arquivo = new File(arquivoQuartos);
        File temp = new File(arquivo.getParent(), "temp.txt");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                Quarto q = linhaParaQuarto(linha);

                if (q.numero != numeroRemover) {
                    bw.write(quartoParaLinha(q));
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
                System.out.println("Quarto não encontrado!");
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

    public void buscarQuarto() {
        File f = new File(arquivoQuartos);

        if (f.length() == 0) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }

        System.out.println("\n=== Buscar Quarto ===");
        int numeroBuscar = Utils.lerInt("Número do quarto: ");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                Quarto q = linhaParaQuarto(linha);

                if (q.numero == numeroBuscar) {
                    encontrado = true;

                    System.out.println("\n--- Quarto Encontrado ---");
                    System.out.println("Número: " + q.numero);
                    System.out.println("Tipo: " + q.tipo);
                    System.out.println("Valor diária: R$ " + q.valorDiaria);
                    System.out.println("Disponível: " + q.disponivel);
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao buscar quarto: " + e.getMessage());
        }

        if (!encontrado) {
            System.out.println("\nNenhum quarto encontrado!");
        }
    }
}
