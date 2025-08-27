package Lista01_Revisao;

public class Exercicio24 {
    public static void main(String[] args) {

        System.out.println("Verificar se um vetor é simétrico.");

        int[] vetor = {1, 2, 3, 2, 1};
        boolean simetrico = true;
        int k = 0;
        for (int i = vetor.length - 1; i >= 0 ; i--) {
            if (vetor[k++] != vetor[i]) {
                System.out.println("O vetor não é simétrico.");
                return;
            }
        }
        System.out.println("O vetor é simétrico.");


    }
}
