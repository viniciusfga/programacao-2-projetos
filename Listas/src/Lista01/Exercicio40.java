package Lista01;

public class Exercicio40 {
    public static void main(String[] args) {

        System.out.println("Remover elementos duplicados de um vetor.");

        int[] vetor = {1, 2, 3, 2, 4, 5, 3, 1};
        int[] unico = new int[vetor.length];
        int k = 0;

        for (int i = 0; i < vetor.length; i++) {
            boolean jaExiste = false;

            for (int j = 0; j < k; j++) {
                if (vetor[i] == unico[j]) {
                    jaExiste = true;
                    break;
                }
            }

            if (!jaExiste) {
                unico[k] = vetor[i];
                k++;
            }
        }

        System.out.print("Vetor sem duplicatas: [");
        for (int i = 0; i < k; i++) {
            System.out.print(unico[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }
}
