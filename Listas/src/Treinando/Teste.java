package Treinando;

public class Teste {

    /*
    INUMERO PRIMO
     */
    public static int verify(int[] vetor, int indice) {

        if(vetor.length == 0 || vetor == null){
            throw new IllegalArgumentException("O vetor não pode estar vazio");
        }

        if(indice == vetor.length - 1) return vetor[indice];

        return vetor[indice] + verify(vetor, indice + 1);
    }

    public static void main(String[] args) {

        int[] vetor = {};
        try {
            int n = verify(vetor, 0);
            System.out.println(n);
        } catch (IllegalArgumentException m){
            System.out.println("ERRO:" + m.getMessage());
        }

        hanoi(3,'A','C','B');
    }

    private static void hanoi(int n, char origem, char destino, char auxiliar) {
        if(n == 1){
            System.out.println(origem + " -> " + destino);
            return;
        }

        hanoi(n - 1, origem, auxiliar, destino);

        System.out.println(origem + " -> " + destino);

        hanoi(n - 1, auxiliar, destino, origem);

    }
}
