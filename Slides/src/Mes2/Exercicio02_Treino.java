package Mes2;

import java.text.Normalizer;
import java.util.Scanner;

public class Exercicio02_Treino {

    public static String normalizar(String s) {

        s = s.trim().toLowerCase();
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[^\\p{ASCII}]", "");
        return s;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        /*
        Receba a busca do usuário
        Remova espaços extras
        Ignore maiúsculas/minúsculas
        Normalize acentos
        Retorne os nomes mais próximos ordenados por similaridade
         */

        String[] palavra = {"João Francisco da Silva", "Joao Francisko da Silva", "João Silva", "Maria Silva"};

        String busca = "joao franscisco da silva"; //input.nextLine();
        busca = busca.trim();

        for (int i = 0; i < palavra.length; i++) {

            if (busca.equalsIgnoreCase(palavra[i].trim())) {
                System.out.println(palavra[i]);
            }
        }

    }
}
