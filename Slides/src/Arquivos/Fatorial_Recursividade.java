package Arquivos;

public class Fatorial_Recursividade {

    public static int gerarFatorial (int n){

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * gerarFatorial(n - 1);
    }

    public static void main(String[] args) {

        int numero = 3;
        int r = gerarFatorial(numero);

        System.out.println(r);

    }
}
