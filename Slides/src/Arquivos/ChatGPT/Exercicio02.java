package Arquivos.ChatGPT;

import java.io.*;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Arquivos/dadosB.csv"));

            String[] nome = new String[5];
            double[] notas = new double[5];

            for (int i = 0; i < 5; i++) {
                System.out.println("Digite o nome do aluno: ");
                nome[i] = sc.nextLine();

                System.out.println("Digite a nota: ");
                notas[i] = sc.nextDouble();
                sc.nextLine(); // limpa o buffer

                bw.write(nome[i] + ";" + notas[i]);
                bw.newLine();
            }

            bw.close();
            System.out.println("Dados salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        // =======================
        // LEITURA DO ARQUIVO
        // =======================

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Arquivos/dadosB.csv"));
            String linha;

            System.out.println("\n--- DADOS LIDOS DO ARQUIVO ---");

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                String nome = dados[0];
                double nota = Double.parseDouble(dados[1]);

                System.out.println("Aluno: " + nome + " | Nota: " + nota);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        sc.close();
    }
}
