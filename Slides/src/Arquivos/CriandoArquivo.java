package Arquivos;

import java.io.File;
import java.io.IOException;

public class CriandoArquivo {
    public static void main(String[] args) {

        String raiz = "C:\\Users\\2025101202010036\\Downloads";

        File arquivo = new File(raiz + File.separator + "arquivo.jpg");

        try {

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso: " + arquivo.getAbsolutePath());
            } else {
                System.out.println("O arquivo já existe: " + arquivo.getAbsolutePath());
            }

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo!");
            e.printStackTrace();
        }
    }
}