package Recursividade;

public class MenorInteiro {

    public static int menorInteiro(int[] vetor, int tamanho) {
        int menor;
        if (tamanho == 1) {
            return vetor[0];
        } else {
            menor = menorInteiro(vetor, vetor[tamanho - 1]);
            if (menor < vetor[tamanho - 1]) return menor;
            else return vetor[tamanho - 1];
        }
    }

    public static void main(String[] args) {

        int menor, vetor[] = {1, 2, 3, 4, 5, 6};
        menor = menorInteiro(vetor, vetor.length);
        System.out.println(menor);

    }
}
