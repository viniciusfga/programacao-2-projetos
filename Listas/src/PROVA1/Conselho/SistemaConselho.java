package PROVA1.Conselho;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaConselho {

    static void mostrarMenu() {
        System.out.println("\n----- SISTEMA DE CONSELHO DE CLASSE -----");
        System.out.println("1 - Cadastrar / Alterar Turmas e Alunos");
        System.out.println("2 - Listar Turmas e Alunos com Problemas");
        System.out.println("3 - Estatísticas Gerais");
        System.out.println("4 - Sair");
        System.out.print("Escolha: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean executando = true;
        Professor prof = new Professor();

        while (executando) {
            try {
                mostrarMenu();
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.println("\n→ Opção: Cadastrar / Alterar");
                        System.out.print("Informe o nome da turma: ");
                        String nomeTurma = sc.nextLine();
                        Turma turma = prof.buscarOuCriarTurma(nomeTurma);

                        boolean addAlunos = true;
                        while (addAlunos) {
                            System.out.print("Nome do aluno: ");
                            String nomeAluno = sc.nextLine();

                            System.out.println("Tipo de problema:");
                            for (TipoProblema tp : TipoProblema.values()) {
                                System.out.println((tp.ordinal() + 1) + " - " + tp);
                            }
                            System.out.print("Escolha: ");
                            int tipo = sc.nextInt();
                            sc.nextLine();

                            if (tipo < 1 || tipo > TipoProblema.values().length) {
                                System.out.println("Tipo inválido!");
                            } else {
                                turma.adicionarAluno(new Aluno(nomeAluno, TipoProblema.values()[tipo - 1]));
                                System.out.println("Aluno cadastrado!");
                            }

                            System.out.print("Deseja adicionar outro aluno nesta turma? (s/n): ");
                            addAlunos = sc.nextLine().equalsIgnoreCase("s");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n→ Opção: Listar Turmas");
                        prof.listarTurmas();
                    }

                    case 3 -> {
                        System.out.println("\n→ Opção: Estatísticas");
                        prof.exibirEstatisticas();
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
