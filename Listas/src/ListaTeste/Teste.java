package ListaTeste;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;


public class Teste {

    /*
    8 - Escreva uma função recursiva para determinar se uma palavra é um palíndromo.
     */
    public static boolean verificar(String palavra, int inicio, int fim)  {

        if (inicio >= fim) {
            return true;
        }

        if (palavra.charAt(inicio) != palavra.charAt(fim)) {
            return false;
        }

        return verificar(palavra, inicio + 1, fim - 1);
    }

    public static void main(String[] args) {

        String palavra= "ovo";

        boolean isPalindromo = verificar(palavra, 0, palavra.length() - 1);

        if(isPalindromo) System.out.println("É palindromo");

    }

}
