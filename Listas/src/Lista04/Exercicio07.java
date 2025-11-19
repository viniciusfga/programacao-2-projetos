package Lista04;

public class Exercicio07 {

    public static int menorRecursivo(int[] vetor, int indice) {

        // Se o vetor for nulo ou vazio, disparamos uma exceção
        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("O vetor não pode ser nulo ou vazio.");
        }

        // Caso base: último índice - o menor é o próprio valor
        if (indice == vetor.length - 1) {
            return vetor[indice];
        }

        // Chama recursão para o restante do vetor
        int menorDoResto = menorRecursivo(vetor, indice + 1);

        // Retorna o menor entre o atual e o resto
        return Math.min(vetor[indice], menorDoResto);
    }

    public static void main(String[] args) {

        try {
            int[] v = {8, 3, 10, -4, 7};

            int menor = menorRecursivo(v, 0);

            System.out.println("Menor valor: " + menor);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
