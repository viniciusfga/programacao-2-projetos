package REVISAO.Exercicio02;

import java.util.Scanner;

public class Main {

    static void verificarComandos(String programa, String[] comandosValidos) {
        String[] palavras = programa.split(" ");
        int comandosCorretos = 0;

        // 1️⃣ Contar comandos válidos
        for (String palavra : palavras) {
            for (String valido : comandosValidos) {
                if (palavra.equals(valido)) {
                    comandosCorretos++;
                    break; // encontrou correspondência, não precisa continuar
                }
            }
        }

        // 2️⃣ Verificar parênteses
        int contPar = 0;
        boolean parBalanceado = true;
        for (char c : programa.toCharArray()) {
            if (c == '(') contPar++;
            else if (c == ')') {
                contPar--;
                if (contPar < 0) {
                    parBalanceado = false;
                    break;
                }
            }
        }
        if (contPar != 0) parBalanceado = false;

        // 3️⃣ Verificar operadores lógicos
        boolean operadoresCorretos = true;
        for (int i = 0; i < palavras.length; i++) {
            String p = palavras[i];
            if (p.equals("AND") || p.equals("OR")) {
                // precisa ter dois operandos válidos ao redor
                if (i == 0 || i == palavras.length - 1) {
                    operadoresCorretos = false;
                    break;
                }
                boolean op1 = palavraValida(palavras[i - 1], comandosValidos);
                boolean op2 = palavraValida(palavras[i + 1], comandosValidos);
                if (!op1 || !op2) {
                    operadoresCorretos = false;
                    break;
                }
            } else if (p.equals("NOT")) {
                // precisa de um operando válido à frente
                if (i == palavras.length - 1) {
                    operadoresCorretos = false;
                    break;
                }
                if (!palavraValida(palavras[i + 1], comandosValidos)) {
                    operadoresCorretos = false;
                    break;
                }
            }
        }

        // 4️⃣ Saída
        System.out.println("Caracteres digitados: " + programa.length());
        System.out.println("Comandos corretos: " + comandosCorretos);
        System.out.println("Parênteses balanceados: " + (parBalanceado ? "sim" : "não"));
        System.out.println("Operadores corretos: " + (operadoresCorretos ? "sim" : "não"));
    }

    static boolean palavraValida(String palavra, String[] comandosValidos) {
        for (String c : comandosValidos) {
            if (palavra.equals(c)) return true;
        }
        // também considera uma expressão entre parênteses como válida
        if (palavra.startsWith("(") && palavra.endsWith(")")) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] comandosValidos = {"iniciar", "parar", "ler", "escrever", "somar",
                "subtrair", "multiplicar", "dividir", "imprimir", "calcular"};

        System.out.println("Digite o programa em uma linha:");
        String programa = sc.nextLine();

        verificarComandos(programa, comandosValidos);
    }
}
