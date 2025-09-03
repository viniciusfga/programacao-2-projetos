package Lista02;

import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a expressão lógica (p, q, r e operadores ! ^ v >): ");
        String expr = sc.nextLine().replaceAll("\\s+", "");

        // Identifica as variáveis usadas
        boolean usaP = expr.contains("p");
        boolean usaQ = expr.contains("q");
        boolean usaR = expr.contains("r");

        boolean tautologia = true;

        System.out.println("p\tq\tr\tResultado");

        for (int i=0; i<2; i++) {          // p
            boolean p = i==1;
            for (int j=0; j<2; j++) {      // q
                boolean q = j==1;
                for (int k=0; k<2; k++) {  // r
                    boolean r = k==1;

                    // Substituir valores na expressão
                    String exp = expr;
                    if (usaP) exp = exp.replace("p", p ? "1" : "0");
                    if (usaQ) exp = exp.replace("q", q ? "1" : "0");
                    if (usaR) exp = exp.replace("r", r ? "1" : "0");

                    // Avaliar expressão simples
                    boolean resultado = avaliarSimples(exp);

                    System.out.printf("%d\t%d\t%d\t%d%n", p?1:0, q?1:0, r?1:0, resultado?1:0);

                    if (!resultado) tautologia = false;
                }
            }
        }

        if (tautologia) {
            System.out.println("A expressão é uma TAUTOLOGIA.");
        } else {
            System.out.println("A expressão NÃO é uma tautologia.");
        }

        sc.close();
    }

    // Avaliação simples de expressão sem parênteses
    private static boolean avaliarSimples(String exp) {
        // Negação
        while (exp.contains("!")) {
            int i = exp.indexOf("!");
            char c = exp.charAt(i+1);
            char val = (c=='1') ? '0' : '1';
            exp = exp.substring(0,i) + val + exp.substring(i+2);
        }

        // Implicação >
        while (exp.contains(">")) {
            int i = exp.indexOf(">");
            char a = exp.charAt(i-1);
            char b = exp.charAt(i+1);
            char val = ((a=='1' && b=='0') ? '0' : '1');
            exp = exp.substring(0,i-1) + val + exp.substring(i+2);
        }

        // Conjunção ^
        while (exp.contains("^")) {
            int i = exp.indexOf("^");
            char a = exp.charAt(i-1);
            char b = exp.charAt(i+1);
            char val = (a=='1' && b=='1') ? '1' : '0';
            exp = exp.substring(0,i-1) + val + exp.substring(i+2);
        }

        // Disjunção v
        while (exp.contains("v")) {
            int i = exp.indexOf("v");
            char a = exp.charAt(i-1);
            char b = exp.charAt(i+1);
            char val = (a=='1' || b=='1') ? '1' : '0';
            exp = exp.substring(0,i-1) + val + exp.substring(i+2);
        }

        return exp.equals("1");
    }
}
