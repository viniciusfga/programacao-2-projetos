package Recursividade;

public class Fibonacci {

    public static int fibonacci(int a){
        if (a <= 1) {
            return a;
        }
        return fibonacci(a - 1) + fibonacci(a - 2);
    }
    public static void main(String[] args) {

        //  1,1,2,3,5,8,13,21...F(n - 1)+F(n - 2);
        int a = 5;
        a = fibonacci(a);
        System.out.println(a);
    }
}
