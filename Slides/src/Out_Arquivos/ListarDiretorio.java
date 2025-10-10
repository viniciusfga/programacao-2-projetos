package Out_Arquivos;

import java.io.File;
import javax.swing.JOptionPane;

public class ListarDiretorio {
    public static void main(String[] args) {
        String path = JOptionPane.showInputDialog("Forneça o caminho do diretório (utilize / entre os diretórios)");

        File dir = new File(path);

        if (dir.isDirectory()) {
            System.out.println("Conteudo do diretório: " + path);
            String s[] = dir.list();
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        } else {
            System.out.println(path + "não é um diretório válido");
        }
    }
}