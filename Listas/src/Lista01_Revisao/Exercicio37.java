package Lista01_Revisao;

public class Exercicio37 {
    public static void main(String[] args) {

        System.out.println("Verificar se vetor A está contido em vetor B.");

        int[] vetorA =  {0, 1, 2, 3, 4, 5};
        int[] vetorB =  {1,2,3};

        int cont = 0;
        for (int i = 0; i < vetorB.length; i++) {
            for (int j = 0; j < vetorA.length; j++) {
                if (vetorB[i] == vetorA[j]) {
                    cont++;
                }
            }
        }
        if (cont == vetorB.length) {
            System.out.println("Está contido");
        } else {
            System.out.println("não está");
        }

    }
}
