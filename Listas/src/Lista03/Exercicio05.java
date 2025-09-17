package Lista03;

import java.util.Scanner;

public class Exercicio05 {
    /*
    Escreva um programa em Java que receba um texto (String)
    e uma lista de palavras proibidas (List<String> ou array de Strings).
    O programa deve remover todas as ocorrências dessas palavras proibidas do texto
     */
    static String removerPalavra(String texto, String[] proibidas) {
        String textoLimpo = "";

        String[] palavras = texto.split(" ");

        for (String palavra : palavras) {
            boolean proibida = false;

            for (String p : proibidas) {
                if (palavra.equalsIgnoreCase(p)) {
                    proibida = true;
                    break;
                }
            }

            if (!proibida) {
                textoLimpo += palavra + " ";
            }
        }

        return textoLimpo.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("TEXTO: ");
        String texto = sc.nextLine();

        System.out.println("PALAVRAS QUE NÃO PODEM APARECER: ");
        String[] proibidas = sc.nextLine().split(" ");

        String textoLimpo = removerPalavra(texto, proibidas);
        System.out.println(textoLimpo);

    }
}
