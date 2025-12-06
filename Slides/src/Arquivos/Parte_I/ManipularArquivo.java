package Arquivos.Parte_I;

import java.io.File;
import java.util.Scanner;

public class ManipularArquivo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("Folders");
        for(File folder : folders){
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);

        System.out.println("Files");
        for(File file : files){
            System.out.println(file);
        }

        boolean soccess = new File(strPath  + "\\subdir").mkdir();
        System.out.println("Soccess" +  soccess);


        sc.close();

    }
}
