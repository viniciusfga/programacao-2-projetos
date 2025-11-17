package Excecao;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercicio03_ArquivoThrows {
    public static void main(String[] args) throws IOException {

        String frase = JOptionPane.showInputDialog("Digite uma frase: ");


        try (PrintWriter out = new PrintWriter(new FileWriter("C:/Users/2025101202010036/Downloads/frases.txt", true))) {
            out.println(frase);
        } catch (IOException e) {
        System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
//            FileWriter file = new FileWriter("C:/Users/2025101202010036/Downloads/frases.txt", true);
//            PrintWriter out = new PrintWriter(file);
//            out.print(frase);
//            file.close();
//            out.close();

        JOptionPane.showMessageDialog(null, "Frase armazenada no aquivo");
    }
}
