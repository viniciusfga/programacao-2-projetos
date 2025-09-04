package Estruturas;

import java.util.*;

public class Bee_1244 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int qdtStrings = Integer.parseInt(input.nextLine());

        for (int i = 0; i < qdtStrings; i++) {
            String linha = input.nextLine();
            String[] palavras = linha.split(" ");

            List<String> ordem = new ArrayList<>(Arrays.asList(palavras));

            ordem.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

            for (int j = 0; j < ordem.size(); j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(ordem.get(j));
            }
            System.out.println();
        }

        input.close();
    }
}
