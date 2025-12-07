package Lista01;

public class Exercicio21 {
    public static void main(String[] args) {

        System.out.println("Imprimir os primeiros 20 termos da sequência de Fibonacci.");

        int n = 20;
        int a = 0, b = 1;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.println(" " + next);
            a = b;
            b = next;
        }

    }
}
