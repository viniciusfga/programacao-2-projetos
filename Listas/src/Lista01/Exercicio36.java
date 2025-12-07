package Lista01;

public class Exercicio36 {
    public static void main(String[] args) {

        System.out.println("Ordenar vetor de valores.");

        int[] vetor = {1, 0, 4, 6, 7, 2};
        // EM ORDEM CRESCENTE

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if (vetor[i] < vetor[j]  ) {
                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;

                }
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }


    }
}
