package Out_Arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExemploWriter {
    /*
    Classe utilizada para ler um arquivo e copiá-lo.
    */
    public void copiarArquivo(String entrada, String saida) {
        Reader reader = null;
        Writer writer = null;

        try {
            reader = new FileReader(entrada);
            writer = new FileWriter(saida);

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c); // Mostra o conteúdo no console
                writer.write(c);
            }
            System.out.println("\nArquivo copiado com sucesso!");

        } catch (FileNotFoundException ex) {
            System.out.println(entrada + " ou " + saida + " não existem!");

        } catch (IOException ex) {
            System.out.println("Erro de leitura ou escrita do arquivo!");

        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo de entrada: " + entrada);
            }

            try {
                if (writer != null) writer.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo de saída: " + saida);
            }
        }
    }

    public static void main(String[] args) {

        ExemploWriter exemplo = new ExemploWriter();
        Scanner s = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo de entrada: ");
        String entrada = s.nextLine();

        System.out.print("Digite o caminho do arquivo de saída: ");
        String saida = s.nextLine();

        exemplo.copiarArquivo(entrada, saida);

        s.close();
    }
}
