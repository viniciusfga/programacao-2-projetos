package Set;

import java.text.Normalizer;
import java.util.Scanner;

public class Exercicio02_Treino {

    public static String normalizar(String s) {
        return Normalizer.normalize(s.trim().toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] palavras = {
                "João Francisco da Silva",
                "Joao Francisko da Silva",
                "João Silva",
                "Maria Silva"
        };

        String busca = "joao"; //input.nextLine();

        busca = normalizar(busca);

        for (int i = 0; i < palavras.length; i++) {
            if (busca.equals(normalizar(palavras[i]))) {
                System.out.println(palavras[i]);
            }
        }
    }
}
