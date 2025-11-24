package Recursividade;

public class OrdemDeChamada {

    public static void recuB(int n) {
        if (n < 5) {
            System.out.println(n);
            recuB(n + 1);
        }
    }

    public static void recuA(int n) {
        if (n < 5) {
            recuB(n + 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {

        int num = 1;
        System.out.println("RECURSÃO A");
        recuA(num);
        System.out.println("RECURSÃO B");
        recuB(num);

    }
}
