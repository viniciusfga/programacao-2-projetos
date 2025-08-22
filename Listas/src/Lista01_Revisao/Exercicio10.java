package Lista01_Revisao;

public class Exercicio10 {
    public static void main(String[] args) {

        System.out.println("Somar quadrados dos primeiros 50 números.");

        int soma = 0;
        for (int i = 1; i <= 50; i++) {
            int quadrado = i * i;
            soma += quadrado;
        }
        System.out.println(soma);

    }
}
