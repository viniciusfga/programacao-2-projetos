package PROVA01.Conselho;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaConselho {

    static void mostrarMenu() {
        System.out.println("\n----- SISTEMA DE CONSELHO DE CLASSE -----");
        System.out.println("1 - Cadastrar / Alterar");
        System.out.println("2 - Listar Turmas");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Sair");
        System.out.print("Escolha: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean executando = true;

        // Objetos principais (ainda serão usados depois)
        Professor prof = new Professor();
        // Você só precisa criar Turmas e Alunos conforme as opções do menu
        // TipoProblema será um ENUM — não precisa de new TipoProblema()

        while (executando) {
            try {
                mostrarMenu();
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.println("→ Opção: Cadastrar / Alterar");
                        prof.cadastrarTurma();
                        // aqui você chamará o método prof.cadastrarTurma() ou algo similar
                    }
                    case 2 -> {
                        System.out.println("→ Opção: Listar Turmas");
                        // ex: prof.listarTurmas();
                    }
                    case 3 -> {
                        System.out.println("→ Opção: Estatísticas");
                        // ex: gerarRelatorios();
                    }
                    case 4 -> {
                        System.out.println("Saindo do sistema...");
                        executando = false;
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERRO: você não digitou um número válido!");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
