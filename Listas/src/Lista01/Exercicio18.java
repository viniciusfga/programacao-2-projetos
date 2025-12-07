package Lista01;

import java.util.Random;
import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        final int LIMITE = 10;
        int numeroSecreto = random.nextInt(LIMITE) + 1;
        int tentativas = 0;
        int chute = 0;

        System.out.println("Jogo de adivinhação com dicas de alto/baixo.");

        System.out.println("=== JOGO DE ADIVINHAÇÃO ===");
        System.out.println("Tente adivinhar o número secreto entre 1 e 10!");

        while (chute != numeroSecreto) {
            System.out.println("Digite seu palpite");
            chute = sc.nextInt();
            tentativas++;

            if (tentativas == 4) {
                System.out.println("VOCÊ ATINGIU O NÚMERO DE TENTATIVAS :( ");
            }

            if (chute == numeroSecreto) {
                System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
            } else {
                int diferenca = Math.abs(chute - numeroSecreto);

                if (chute < numeroSecreto) {
                    if (diferenca <= 2) {
                        System.out.println("Está perto, mas ainda é BAIXO. Tente um pouco maior");
                    } else {
                        System.out.println("Muito baixo! Tente um número maior.");
                    }
                } else {
                    if (diferenca <= 2) {
                        System.out.println("Está perto, mas ainda é ALTO. Tente um pouco menor");
                    } else {
                        System.out.println("Muito alto! Tente um número menor.");
                    }
                }
            }
        }

        sc.close();
    }
}
