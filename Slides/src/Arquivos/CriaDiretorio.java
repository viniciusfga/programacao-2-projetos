package Arquivos;

import java.io.File;

public class CriaDiretorio {
    public static void main(String[] args) {

        String raiz = "C:\\Users\\2025101202010036\\Downloads";

        String programacao = raiz + File.separator + "programacao";
        String loja = programacao + File.separator + "loja";

        String[] subpastas = {"imagens", "videos", "sons"};

        File dirProgramacao = new File(programacao);

        if (!dirProgramacao.exists()) {
            dirProgramacao.mkdir();
            System.out.println("Criado: " + dirProgramacao.getAbsolutePath());
        }

        File dirLoja = new File(loja);

        if (!dirLoja.exists()) {
            dirLoja.mkdir();
            System.out.println("Criado: " + dirLoja.getAbsolutePath());
        }

        for (String nome : subpastas) {
            File subdir = new File(loja + File.separator + nome);
            if (!subdir.exists()) {
                subdir.mkdir();
                System.out.println("Criado: " + subdir.getAbsolutePath());
            }
        }

        System.out.println("Final do processo de criação");

    }
}