package Excecao;

import java.util.Scanner;

public class Exercicio05 {
    /*

    F( x ) = x³ + x²
    P = F(a) + F(a + h) + F(a + 2h) + F(a + n*h)

     */
    static double f(double k) {
        return Math.pow(k, 2) + Math.pow(k, 3);
    }

    static void calcularExpressao(int a, int h, int n){

        int P = (int) f(a);

        for (int i = 0; i < n; i++) {
            P += (int) f(a + i*h);
        }

        System.out.println(P);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int H = sc.nextInt();
        int N = sc.nextInt();

        calcularExpressao(A, H, N);

    }
}
