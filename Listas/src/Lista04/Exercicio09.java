package Lista04;

public class Exercicio09 {

    public static int somaElementos(int[] vetor, int indice) {

        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("O vetor não pode ser nulo ou vazio.");
        }

        // Caso base: chegou no último índice
        if (indice == vetor.length - 1) {
            return vetor[indice];
        }

        // Soma o elemento atual com a soma do restante
        return vetor[indice] + somaElementos(vetor, indice + 1);
    }

    public static void main(String[] args) {


        try {
            int[] v = {2, 4, 6, 8};

            int soma = somaElementos(v, 0);

            System.out.println("Soma dos elementos: " + soma);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}

