package Arquivos.ChatGPT;

import java.io.File;
import java.io.IOException;

public class CriarArquivo {

    public static void main(String[] args) {

        try {

            File file = new File("src/Arquivo/dados.txt");

            if (file.createNewFile()) {
                System.out.println("Arquivo criado com sucesso!");
            } else {
                System.out.println("Arquivo já existe!");
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}

