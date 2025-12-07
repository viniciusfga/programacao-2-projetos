package Arquivos.ChatGPT;

import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo {

    public static void main(String[] args) {

        try {

            FileWriter fw = new FileWriter("src/Arquivo/dados.txt");
            fw.write("Arquivo Criado");
            fw.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
