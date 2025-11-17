package Recursividade;

public class Fatorial {

    public static int fatorial(int a){
        if (a == 0) {
            return 1;
        }
        return fatorial(a - 1) * a;
    }

    public static void main(String[] args) {

        int a = 6;
        a = fatorial(a);
        System.out.println(a);

    }
}
