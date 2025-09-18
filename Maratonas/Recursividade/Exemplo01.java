public class Exemplo01 {

    static void Fn(int i) {
        System.out.println(i);
        if (i == 10)
            return;
        Fn(i + 1);
        System.out.println(i);
    }

    public static void main(String[] args) {

        Fn(0);
    }
}
