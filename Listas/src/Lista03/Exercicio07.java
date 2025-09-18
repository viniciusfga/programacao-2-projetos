package Lista03;
import java.util.Scanner;

public class Exercicio07 {
    /*
    Remova palavras duplicadas consecutivas em um texto (ex.: "oi oi tudo bem" -> "oi tudo bem")
     */

    static String removerDuplicados(String str) {
        String resultado = "";

        String[] palavras = str.split(" ");
        for (int i = 0; i < palavras.length; i++) {
            for (int j = i + 1; j < palavras.length; j++) {
                if (palavras[i].equals(palavras[j])) {
                    palavras[j]  = "";
                }
            }
            resultado += palavras[i] + " ";
        }

        return resultado.strip().replaceAll("\\s+", " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto;

        texto = "oi oi tudo bem"; //sc.nextLine();
        String resultado = removerDuplicados(texto);
        System.out.println(resultado);

    }
}
