package Mes1;

import java.util.Scanner;

public class Exercicio01_Treino {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Elaborar um programa que permita a entrada de um número inteiro entre 1 e 9999 e o escreva por extenso");

        System.out.println("Digite um número inteiro entre 1 e 9999:");
        int N = sc.nextInt();

        if (N < 1 || N > 9999) {
            System.out.println("Número fora do intervalo permitido!");
            sc.close();
            return;
        }

        String resultadoFinal;

        if (N < 1000) {
            resultadoFinal = numeroPorExtenso(N);
        } else {
            int milhares = N / 1000;
            int resto = N % 1000;

            resultadoFinal = numeroPorExtenso(milhares) + " mil";
            if (resto != 0) {
                resultadoFinal += " " + numeroPorExtenso(resto);
            }
        }

        System.out.println(resultadoFinal);
        sc.close();
    }

    public static String numeroPorExtenso(int numero) {
        if (numero == 0) {
            return "zero";
        }

        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
        String[] centenas = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

        String resultado = "";

        if (numero < 20) {
            resultado = unidades[numero];
        } else if (numero < 100) {
            resultado = dezenas[numero / 10];
            if (numero % 10 != 0) {
                resultado += " e " + unidades[numero % 10];
            }
        } else if (numero < 1000) {
            if (numero == 100) {
                resultado = "cem";
            } else {
                resultado = centenas[numero / 100];
                int resto = numero % 100;
                if (resto != 0) {
                    if (resto < 20) {
                        resultado += " e " + unidades[resto];
                    } else {
                        resultado += " e " + dezenas[resto / 10];
                        if (resto % 10 != 0) {
                            resultado += " e " + unidades[resto % 10];
                        }
                    }
                }
            }
        }
        return resultado;
    }
}
