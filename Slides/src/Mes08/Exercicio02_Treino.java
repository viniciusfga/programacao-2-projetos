package Mes08;

import java.util.Scanner;

public class Exercicio02_Treino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Grau da expansão (n): ");
        int n = sc.nextInt();

        String resultado = "(a + b)^" + n + " = ";

        int coeficiente = 1;

        for (int i = 0; i <= n; i++) {
            if (i > 0) {

                coeficiente = coeficiente * (n - i + 1) / i;
                resultado += " + ";
            }

            if (coeficiente != 1 || (n - i == 0 && i == 0)) {
                resultado += coeficiente;
                if (n - i > 0 || i > 0) resultado += "*";
            }

            // expoente de a
            if (n - i > 0) {
                resultado += "a";
                if (n - i > 1) resultado += "^" + (n - i);
                if (i > 0) resultado += "*";
            }

            // expoente de b
            if (i > 0) {
                resultado += "b";
                if (i > 1) resultado += "^" + i;
            }
        }

        System.out.println(resultado);
        sc.close();

    }
}


