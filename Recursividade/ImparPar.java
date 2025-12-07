package Recursividade;

public class ImparPar {

    public static boolean isEven(int n) {
        if (n == 0) {
            return true;
        } else {
            return isOdd(n -1);   // chamada recursiva indireta
        }
    }

    public static boolean isOdd(int n) {
        if (n == 0) {
            return false;
        } else {
            return isEven(n -1); // chamada recursiva indireta
        }
    }

    public static void main(String[] args) {

        int numero = 2;
        if (isEven(numero))
            System.out.println("É PAR");
        else
            System.out.println("É IMPAR");
    }
}
