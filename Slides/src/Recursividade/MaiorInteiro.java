package Recursividade;

public class MaiorInteiro {

    public static int maiorinteiro(int v[], int n) {
        int m;
        if (n == 1) {
            return v[0];
        } else {
            m = maiorinteiro(v, n - 1);
            if(m > v[n-1]) return m;
            else return v[n-1];
        }
    }

    public static void main(String[] args) {

        int max, v[] = {13,23,53,1,3,5,445};
        max = maiorinteiro(v, 7);
        System.out.println("Max: " + max);

    }
}
