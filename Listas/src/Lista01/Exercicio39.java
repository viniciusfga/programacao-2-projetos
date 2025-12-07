package Lista01;

public class Exercicio39 {
    public static void main(String[] args) {

        System.out.println("Calcular mediana de um vetor.");

        int[] vetor = {7, 2, 5, 3, 9, 10};

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        double mediana;
        int n = vetor.length;
        if (n % 2 == 1) { // ímpar
            mediana = vetor[n / 2];
        } else { // par
            mediana = (vetor[n / 2 - 1] + vetor[n / 2]) / 2.0;
        }

        System.out.print("Vetor ordenado: [");
        for (int i = 0; i < n; i++) {
            System.out.print(vetor[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Mediana: " + mediana);

    }
}
