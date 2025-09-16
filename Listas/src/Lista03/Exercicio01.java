package Lista03;

import java.util.Scanner;

public class Exercicio01 {
    /*
    Extraia o domínio (após '@') de um endereço de e mail.
     */
    static String extrairDominio(String email) {
        String dominio = "";
        boolean depoisDominio = false;

        // 1 - dominio = email.split("@")[1];
        // 2 - int posicao = email.indexOf("@");
        //     dominio = email.substring(posicao + 1);

        for (int i = 0; i < email.length(); i++) {

            if (email.charAt(i) == '@') {
                depoisDominio = true;
                continue;
            }
            if (depoisDominio == true) {
                dominio += email.charAt(i);
            }
        }

        return dominio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String email = sc.next();
        String dominio = extrairDominio(email);
        System.out.println(dominio);

    }
}
