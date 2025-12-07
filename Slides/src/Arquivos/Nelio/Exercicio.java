package Arquivos.Nelio;

import java.io.*;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // MATRIZES PARA ARMAZENAR OS DADOS
        String[] nome = new String[100];
        double[] preco = new double[100];
        int[] quantidade = new int[100];
        double[] total = new double[100];

        int cont = 0; // controlador de indice;

        // CAMINHO DO ARQUIVO
        System.out.println("Digite o caminho COMPLETO do arquivo itens.csv:");
        String caminhoArquivoStr = sc.nextLine();

        // CAMINHO DA PASTA
        File pastaDoArquivo = new File(caminhoArquivoStr);
        String caminhoPastaStr = pastaDoArquivo.getParent();

        // CRIANDO PASTA "saida"
        File pastaSaida = new File(caminhoPastaStr + "/saida");
        pastaSaida.mkdir();

        String arquivoSumario = caminhoPastaStr + "/saida/summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoStr))) {

            String linha = br.readLine();

            while (linha != null) {

                String[] itens = linha.split(",");
                nome[cont] = itens[0];
                preco[cont] = Double.parseDouble(itens[1]);
                quantidade[cont] = Integer.parseInt(itens[2]);
                total[cont] = preco[cont] * quantidade[cont];

                cont++;
                linha = br.readLine();
            }

        } catch (IOException e){
            System.out.println("Erro " + e.getMessage());
        }

        // ===== ESCRITA DO ARQUIVO =====
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSumario))) {

            for (int i = 0; i < cont; i++) {
                bw.write(
                        nome[i] + "," +
                        preco[i] + "," +
                        quantidade[i] + "," +
                        total[i]
                );
                bw.newLine();
            }
            System.out.println("Arquivo summary.csv criado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro " + e.getMessage());
        }

        sc.close();
    }
}