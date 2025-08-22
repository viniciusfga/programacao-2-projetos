package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("mprimir tabuada de um número informado pelo usuário.");

        int n =  sc.nextInt();

        for (int i = 1; i <= 10; i++){
            System.out.println(n + " x " + i + " = " + n * i);
        }

    }
}
