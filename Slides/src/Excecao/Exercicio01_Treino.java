package Excecao;

import java.util.Scanner;

public class Exercicio01_Treino {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Liste todas as substrings de uma palavra");

        String palavra = input.nextLine();

        for (int i = 0; i < palavra.length(); i++) {

            for (int j = i + 1; j <= palavra.length(); j++) {

                String substring = palavra.substring(i,j);
                System.out.println("substring = " + substring);
            }
        }

    }
}
