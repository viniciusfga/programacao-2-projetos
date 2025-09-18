public class Exemplo02 {

    // método recursivo que RETORNA int

    static int Fn(int i) {
        if (i <= 1) {          // caso base
            return 1;          // fatorial de 0 ou 1 é 1
        }
        return i * Fn(i - 1);  // chamada recursiva
    }

    public static void main(String[] args) {
        int res = Fn(5); // calcula 5!
        System.out.println(res); // imprime 120
    }
}
