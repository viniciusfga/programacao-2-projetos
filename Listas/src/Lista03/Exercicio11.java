package Lista03;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();

        int menorTempo = Integer.MAX_VALUE;

        // Para cada quantidade de viradas da ampulheta A
        for (int x = 1; x <= 1000; x++) {
            int tempoA = A * x;

            // Testamos também para B
            for (int y = 1; y <= 1000; y++) {
                int tempoB = B * y;

                // Se a diferença dos tempos for exatamente T (cozimento exato)
                if (Math.abs(tempoA - tempoB) == T) {
                    int tempoTotal = Math.max(tempoA, tempoB);
                    if (tempoTotal < menorTempo) {
                        menorTempo = tempoTotal;
                    }
                }
            }
        }

        System.out.println(menorTempo);
    }
}
