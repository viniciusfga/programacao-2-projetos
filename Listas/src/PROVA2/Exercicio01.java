package PROVA2;

import org.w3c.dom.ls.LSOutput;

public class Exercicio01 {

    //RECURSIVO
    public static int russa(int a, int b, int p) {
        print(a, b, p);

        if (a % 2 == 0) p = 0;
        if (a == 1) return b;

        a = a / 2;
        b = b * 2;

        return p + russa(a, b, b);
    }

    public static void print(int a, int b, int p) {
        if (a % 2 != 0) { // IMPAR
            System.out.println(a + " " + b + " " + p);
        } else { // PAR - NÃO MOSTRA A PARCELA
            System.out.println(a + " " + b + " ");
        }
    }

    //INTERATIVO
    public static int russaB(int a, int b, int p) {

        int soma = 0;

        while (true) {
            print(a, b, p);

            if (a % 2 != 0) {
                soma += b;
            }

            a = a / 2;
            b = b * 2;
            p = b;

            if (a < 1) {
                break;
            }
        }

        return soma;
    }

    public static void main(String[] args) {

        int A = 27;
        int B = 82;
        int PARCELAS = B;

        System.out.println("A   B   PARCELAS");
        int soma = russa(A,B, PARCELAS);
        //int soma = russaB(A, B, PARCELAS);

        System.out.println("SOMA: " + soma);

    }
}
