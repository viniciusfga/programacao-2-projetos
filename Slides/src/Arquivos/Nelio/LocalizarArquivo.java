package Arquivos.Nelio;

import java.io.IOException;
import java.util.Scanner;

public class LocalizarArquivo {

    public static void main(String[] args) {

        java.io.File file = new java.io.File("Slides/src/Arquivos/Parte_I/mensagem.txt");
        // testar se o caminho está correto de verdade
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());

        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }


    }
}
