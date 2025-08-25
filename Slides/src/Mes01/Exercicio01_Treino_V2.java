package Mes01;

import java.util.Scanner;

public class Exercicio01_Treino_V2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Elaborar um programa que permita a entrada de um número inteiro entre 1 e 9999 e o escreva por extenso");

        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        String[] dezenasDez = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
        String[] centenas = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

        System.out.println("Digite um número inteiro entre 1 e 9999:");
        //int N = sc.nextInt();
        int N = 9000;

        if (N < 1 || N > 9999) {
            System.out.println("Número fora do intervalo permitido!");
            sc.close();
            return;
        }

        String extenso = "";

        if ( N >= 1000) {
            int milhar = N / 1000;
            extenso += (milhar == 1 ? "mil" : unidades[milhar] + "mil");
        }

        System.out.println("Por extenso: " + extenso);
        sc.close();
    }
}
