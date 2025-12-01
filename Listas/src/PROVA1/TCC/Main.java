package PROVA1.TCC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Método para ler cadastro de TCC
    static TCCs.TCC lerCadastro(Scanner sc) {
        sc.nextLine(); // limpa buffer
        System.out.print("Número da avaliação: ");
        int numeroAvaliacao = sc.nextInt();
        sc.nextLine(); // limpa buffer
        System.out.print("Nome do TCC: ");
        String nome = sc.nextLine();
        System.out.print("Nome do Aluno 1: ");
        String alunoA = sc.nextLine();
        System.out.print("Nome do Aluno 2 (ou N se não houver): ");
        String alunoB = sc.nextLine();
        System.out.print("Nome do Orientador: ");
        String orientador = sc.nextLine();

        return new TCCs.TCC(numeroAvaliacao, nome, alunoA, alunoB, orientador);
    }

    // Submenu de gerenciamento
    static void mostrarSubmenu() {
        System.out.println("\n--- MENU DE GESTÃO DE TCC ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.print("Escolha: ");
    }

    static void gerenciar(TCCs matriz, Scanner sc) {
        mostrarSubmenu();
        int op = sc.nextInt();
        sc.nextLine(); // limpa buffer

        switch (op) {
            case 1 -> {
                TCCs.TCC tcc = lerCadastro(sc);
                matriz.cadastrarTCC(tcc.numeroAvaliacao, tcc.nome, tcc.alunoA, tcc.alunoB, tcc.orientador);
            }
            case 2 -> {
                TCCs.TCC tcc = lerCadastro(sc);
                matriz.alterarTCC(tcc.numeroAvaliacao, tcc.nome, tcc.alunoA, tcc.alunoB, tcc.orientador);
            }
            case 3 -> {
                System.out.print("Número da avaliação a excluir: ");
                int numero = sc.nextInt();
                matriz.excluirTCC(numero);
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    static void mostrarMenu() {
        System.out.println("\n----- SISTEMA PARA GESTÃO DE TCCs -----");
        System.out.println("1 - Cadastrar | Alterar | Excluir TCC");
        System.out.println("2 - Listar TCCs");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Excluir TCC");
        System.out.println("5 - Sair");
        System.out.print("Escolha: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TCCs matriz = new TCCs();
        boolean executando = true;

        while (executando) {
            try {
                mostrarMenu();
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> gerenciar(matriz, sc);
                    case 2 -> matriz.listarTCCs();
                    case 3 -> matriz.verEstatisticas();
                    case 4 -> {
                        System.out.println("Saindo...");
                        executando = false;
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: você não digitou um número válido!");
                sc.nextLine(); // limpa entrada inválida
            }
        }
        sc.close();
    }
}
