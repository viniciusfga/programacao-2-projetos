package Lista03;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio09 {
    /*
    9- Implemente um o tratamento de exceções em que uma exceção grava uma mensagem em um arquivo
    antes de terminar.
     */
    static void registrarErro(Exception e) {
        try (FileWriter fw = new FileWriter("log.txt", true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Erro: " + e.toString());
            bw.newLine();

        } catch(Exception ioEx) {
            ioEx.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            registrarErro(e);
            System.exit(1);
        }
    }
}
