package Lista03;

import java.util.Scanner;

public class Exercicio04 {
    /*
    Ache a palavra mais longa em uma frase
     */
    static String verificarPalavras(String t) {

        String[] palavras = t.split(" ");
        String palavraMaisLonga  = palavras[0];

        int comprimentoMaximo = 0;

        for (String palavra : palavras) {
            if (palavra.length() > comprimentoMaximo) {
                comprimentoMaximo = palavra.length();
                palavraMaisLonga =  palavra;
            }
        }

        return palavraMaisLonga ;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String texto = "A maior palavra é Paralelepipedo";

        String maior = verificarPalavras(texto);
        System.out.println(maior);

        input.close();
    }
}

