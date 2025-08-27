package Lista01_Revisao;
import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Encontrar mínimo e máximo em lista sem funções prontas.");

        System.out.print("Quantos números deseja inserir? ");
        int n = sc.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        int maximo = numeros[0];
        int minimo = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            if (maximo < numeros[i]) {
                maximo = numeros[i];
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if (minimo > numeros[i]) {
                minimo = numeros[i];
            }
        }


        System.out.println("Menor valor: " + minimo);
        System.out.println("Maior valor: " + maximo);

        sc.close();
    }
}
