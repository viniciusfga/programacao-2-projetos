package Lista02;

import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String texto = input.nextLine();

        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char)(c - ('a' - 'A'));
            }
            resultado += c;
        }

        System.out.println("Texto em maiúsculas: " + resultado);
        input.close();
    }
}
