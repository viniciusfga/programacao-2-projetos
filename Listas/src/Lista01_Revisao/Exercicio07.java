package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Gerar sequência de quadrados até limite definido pelo usuário.");

        int n =  sc.nextInt();

        for (int i = 2; i <= n + 1; i++){
            System.out.println(i*i);
        }

    }
}
