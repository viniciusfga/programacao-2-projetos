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

    public QuartoService() {
        inicializarArquivos();
    }

    private void inicializarArquivos() {
        try {
            File dir = new File(arquivoQuartos).getParentFile();
            if (!dir.exists()) dir.mkdirs();

            File arq = new File(arquivoQuartos);
            if (!arq.exists()) arq.createNewFile();

        } catch (IOException e) {
            System.out.println("Erro ao criar arquivos: " + e.getMessage());
        }
    }

    // CALCULA O PRÓXIMO ID AUTOMATICAMENTE
    private int calcularProximoId() {
        File file = new File(arquivoQuartos);

        if (!file.exists() || file.length() == 0)
            return 1; // primeiro quarto

        int maior = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] d = linha.split(";");
                int numero = Integer.parseInt(d[0]);

                if (numero > maior)
                    maior = numero;
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler IDs: " + e.getMessage());
        }

        return maior + 1;
    }

    private Quarto linhaParaQuarto(String linha) {
        String[] d = linha.split(";");
        return new Quarto(
                Integer.parseInt(d[0]),
                d[1],
                Double.parseDouble(d[2]),
                Boolean.parseBoolean(d[3])
        );
    }

    private String quartoParaLinha(Quarto q) {
        return q.numero + ";" + q.tipo + ";" + q.valorDiaria + ";" + q.disponivel;
    }

    public void cadastrarQuarto() {
        int numero = calcularProximoId();  // GERA O ID AUTOMATICAMENTE

        System.out.println("\n--- Cadastro de Quarto ---");

        String tipo = Utils.lerString("Tipo (Simples / Duplo / Luxo): ");
        double valor = Utils.lerDouble("Valor da diária: ");

        Quarto q = new Quarto(numero, tipo, valor, true);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoQuartos, true))) {
            bw.write(quartoParaLinha(q));
            bw.newLine();
            System.out.println("\nQuarto cadastrado com sucesso!");
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

        arquivo.delete();
        temp.renameTo(arquivo);

        if (encontrado)
            System.out.println("Quarto removido com sucesso!");
        else
            System.out.println("Quarto não encontrado!");
    }

    public void apagarTodos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoQuartos))) {
            pw.print("");
            System.out.println("Todos os quartos foram apagados!");
        } catch (IOException e) {
            System.out.println("Erro ao apagar quartos: " + e.getMessage());
        }
    }

    public void buscarQuarto() {
        File f = new File(arquivoQuartos);

        if (f.length() == 0) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }

        int numeroBuscar = Utils.lerInt("\nNúmero do quarto: ");
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
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao buscar quarto: " + e.getMessage());
        }

        if (!encontrado)
            System.out.println("\nNenhum quarto encontrado!");
    }

    public void buscarPorNumeroMenu() {
        int numero = Utils.lerInt("Número do quarto: ");
        Quarto q = buscarPorNumero(numero);

        if (q == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        System.out.println("\n=== Quarto Encontrado ===");
        System.out.println("Número: " + q.numero);
        System.out.println("Tipo: " + q.tipo);
        System.out.println("Valor diária: R$ " + q.valorDiaria);
        System.out.println("Disponível: " + q.disponivel);
    }

    public Quarto buscarPorNumero(int numero) {
        File f = new File(arquivoQuartos);

        if (!f.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Quarto q = linhaParaQuarto(linha);
                if (q.numero == numero) return q;
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar quarto: " + e.getMessage());
        }

        return null;
    }

    public void atualizarQuartoMenu() {
        System.out.println("\n=== Atualizar Quarto ===");

        int numero = Utils.lerInt("Número do quarto a atualizar: ");

        Quarto atual = buscarPorNumero(numero);

        if (atual == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        System.out.println("\nQuarto atual:");
        System.out.println("Número: " + atual.numero);
        System.out.println("Tipo: " + atual.tipo);
        System.out.println("Valor diária: " + atual.valorDiaria);
        System.out.println("Disponível: " + atual.disponivel);

        System.out.println("\nDigite os novos dados (pressione ENTER para manter o valor atual):");

        String novoTipo = Utils.lerString("Tipo (" + atual.tipo + "): ");
        String novoValorStr = Utils.lerString("Valor da diária (" + atual.valorDiaria + "): ");
        String novoDispStr = Utils.lerString("Disponível [true/false] (" + atual.disponivel + "): ");

        // Mantém os valores antigos se o usuário deixar em branco
        String tipo = novoTipo.isEmpty() ? atual.tipo : novoTipo;

        double valor = atual.valorDiaria;
        if (!novoValorStr.isEmpty()) {
            try {
                valor = Double.parseDouble(novoValorStr);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Mantendo valor antigo.");
            }
        }

        boolean disponivel = atual.disponivel;
        if (!novoDispStr.isEmpty()) {
            disponivel = Boolean.parseBoolean(novoDispStr);
        }

        // Cria o objeto atualizado
        Quarto atualizado = new Quarto(
                atual.numero,
                tipo,
                valor,
                disponivel
        );

        // Atualiza no arquivo
        atualizarQuarto(atualizado);

        System.out.println("\nQuarto atualizado com sucesso!");
    }


    public void atualizarQuarto(Quarto atualizado) {
        File arquivo = new File(arquivoQuartos);
        File temp = new File(arquivo.getParent(), "temp_quartos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                Quarto q = linhaParaQuarto(linha);

                if (q.numero == atualizado.numero) {
                    bw.write(quartoParaLinha(atualizado));
                } else {
                    bw.write(quartoParaLinha(q));
                }
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao atualizar quarto: " + e.getMessage());
        }

        arquivo.delete();
        temp.renameTo(arquivo);
    }
}
