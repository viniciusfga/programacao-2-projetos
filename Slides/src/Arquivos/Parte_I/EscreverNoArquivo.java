package Arquivos.Parte_I;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreverNoArquivo {

    public static void main(String[] args) {

        String[] lines = new String[] {"Good Morning","Good Afternoon","Goog Night"};
        String path = "Slides/src/Arquivos/Parte_I/mensagemA.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // (path, true), indique que você não quer recriar o arquivo
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
