package Arquivos.ChatGPT;

import java.io.*;
import java.util.Scanner;

public class LendoArquivos {

    public static void main(String[] args) {

        try {

            File arquivo = new File("src/Arquivo/dadosA.txt");
            Scanner sc = new Scanner(arquivo);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Erro");
        }

        // COM BufferedReader

        try {

            BufferedReader br = new BufferedReader(new FileReader("src/Arquivo/dadosA.txt"));
            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Erro");
        }

    }
}


