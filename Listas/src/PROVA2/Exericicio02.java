package PROVA2;

public class Exericicio02 {

    // RECURSIVO
    static double multiplicar(int[] vetorA, int[] vetorB, int indice) {

        // Caso base: chegou no último índice
        if (indice == vetorA.length - 1) {
            return vetorA[indice] * vetorB[indice];
        }

        return vetorA[indice] * vetorB[indice] + multiplicar(vetorA, vetorB, indice + 1);
    }
    static double somar(int[] vetorB, int indice) {

        // Caso base: chegou no último índice
        if (indice == vetorB.length - 1) {
            return vetorB[indice];
        }

        return vetorB[indice] + somar(vetorB, indice + 1);
    }


    // INTERATIVO
    static double calcularB(int[] vetorA, int[] vetorB) {
        double somaV = 0;
        int somaP = 0;

        for (int i = 0; i < vetorA.length; i++) {
            somaV += vetorA[i] * vetorB[i]; // MULTIPLICA OS ELEMENTOS DO VELOR A POR B E GUARDO NA VARIAVEL SOMA
            somaP += vetorB[i]; // SOMAP RECEBO A SOMA DOS ELEMENTOS DO VETOR B
        }

        return somaV / somaP;
    }

    public static void main(String[] args) {


        int[] vetorA = {2, 3};
        int[] vetorB = {2, 3};
        int indice = 0;

        double resultado = multiplicar(vetorA,vetorB,indice) / somar(vetorB,indice);
        System.out.println(resultado);


    }
}
