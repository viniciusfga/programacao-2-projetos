package Lista04;

public class Exercicio06 {

    public static String inverter(String s) {

        // A string não pode ser nula
        if (s == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }

        // String vazia ou com 1 caractere já está invertida
        if (s.length() <= 1) {
            return s;
        }

        // pega o último caractere + chama recursivamente para o restante
        return s.charAt(s.length() - 1) + inverter(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {

        try {
            String str = "JAVA";

            if (str == null) {
                throw new IllegalArgumentException("A string não pode ser nula.");
            }

            str = inverter(str);
            System.out.println(str);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
