package Lista01_Revisao;

import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Verificar se um número é primo.");

        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Não é número primo");
            sc.close();
            return;
        }


        boolean primo = true;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println(n + "É número primo");
        } else {
            System.out.println(n + "Não é número primo");
        }

        sc.close();

    }
}
