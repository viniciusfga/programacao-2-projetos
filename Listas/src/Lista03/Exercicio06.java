package Lista03;

import java.util.Scanner;

public class Exercicio06 {
    /*
    Mascarar um número de cartão de crédito deixando só os últimos 4 dígitos (ex.: "1234 5678 9012 3456"
    -> "**** **** **** 3456").
     */
    static String mascarar (String card){
        String mascarada = "";

        String ultimos  = card.substring(card.length() - 4);

        int qtdMascara = card.length() - 4;

        for (int i = 0; i < qtdMascara; i++) {
            char c = card.charAt(i);
            if (c == ' '){
                mascarada += " ";
                continue;
            }
            mascarada += "*";
        }

        mascarada += card.substring(card.length() - 4);

        return mascarada;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String cartao = "1234 3678 9012 3456";

        String mascarada = mascarar(cartao);
        System.out.println("Mascara aplicada: " + mascarada);

    }
}
