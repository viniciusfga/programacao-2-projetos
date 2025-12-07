package Arquivos.ChatGPT;

import java.io.*;

public class EscreverLinhas {

    public static void main(String[] args) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Arquivo/dadosA.txt"));

            bw.write("Nome: Fulano");
            bw.newLine();
            bw.write("Curso java");
            bw.close();

        } catch (IOException e) {
            System.out.println("Erro");
        }
    }
}

