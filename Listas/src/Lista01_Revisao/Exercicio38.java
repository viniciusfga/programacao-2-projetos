package Lista01_Revisao;

public class Exercicio38 {
    public static void main(String[] args) {

        System.out.println("Encontrar interseção entre dois vetores.");

        int[] vetor1 = {1, 2, 3, 4, 5};
        int[] vetor2 = {4, 5, 6, 7, 8};

        int[] intersecao = new int[Math.min(vetor1.length, vetor2.length)];
        int k = 0;

        for (int i = 0; i < vetor1.length; i++) {
            boolean jaExiste = false;

            for (int x = 0; x < k; x++) {
                if (intersecao[x] == vetor1[i]) {
                    jaExiste = true;
                    break;
                }
            }

            if (!jaExiste) {

                for (int j = 0; j < vetor2.length; j++) {
                    if (vetor1[i] == vetor2[j]) {
                        intersecao[k] = vetor1[i];
                        k++;
                        break;
                    }
                }
            }
        }

        System.out.print("A intersecção dos vetores é: [");
        for (int i = 0; i < k; i++) {
            System.out.print(intersecao[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}


