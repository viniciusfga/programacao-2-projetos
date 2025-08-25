package Lista01_Revisao;

import java.util.Random;

public class Exercicio19 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Simular lançamento de dado 100 vezes e contar frequência.");

        int[] frequencia = new int[6];

        // Lança o dado 100 vezes
        for (int i = 0; i < 100; i++) {
            int face = random.nextInt(6) + 1;
            frequencia[face - 1]++;
        }

        for (int i = 0; i < frequencia.length; i++) {
            System.out.println("Face " + (i + 1) + ": " + frequencia[i] + " vezes");
        }

    }
}
