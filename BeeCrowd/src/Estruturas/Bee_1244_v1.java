package Estruturas;

import java.util.*;

public class Bee_1244_v1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int qdtStrings = Integer.parseInt(input.nextLine());

        String[] frases = new String[qdtStrings];

        for (int i = 0; i < qdtStrings; i++) {
            frases[i] = input.nextLine();
        }

        ArrayList<String> ordem = new ArrayList<String>();

        String palavra = "";

        for (int i = 0; i < qdtStrings; i++) {

            // TAMANHO DA FRASE i
            for (int j = 0; j < frases[i].length(); j++) {

                if (frases[i].charAt(j) != ' ') {
                    palavra += frases[i].charAt(j);
                    // FORMAÇÃO DA PALAVRA i

                } else if (frases[i].charAt(j) == (' ') || j == (frases[i].length() - 1)) {

                    ordem.add(palavra);
                    palavra = "";

                }
            }
            ordem.add(palavra);
            palavra = "";

            for (int k = 0; k < ordem.toArray().length; k++) {

                String maior = ordem.get(k);
                int count = k;

                for (int w = k + 1; w < ordem.toArray().length; w++) {
                    if (maior.length() <= ordem.get(w).length()) {
                        maior = ordem.get(w);
                        count = w;
                    }
                }
                String aux = ordem.get(k);
                ordem.set(k, maior);
                ordem.set(count, aux);

            }
            // IMPRIMIR
            for (int j = 0; j < ordem.size(); j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(ordem.get(j));
            }
            System.out.println();
        }

        input.close();

    }
}
