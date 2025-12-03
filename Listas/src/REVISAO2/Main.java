package REVISAO2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*
   Faça um programa em Java que use matriz para gerenciar os gastos semanais de uma pessoa,
   onde cada linha representa um mês e cada coluna uma semana.
   O programa deve rodar em loop até o usuário escolher "sair".

   Menu de opções:
   1 – cadastrar/alterar/excluir despesas
   2 – cadastrar/alterar/excluir receitas
   3 – ver estatísticas
   4 – listar meses
   5 – sair
   */

    static class Dados {

        int mes;
        int semana;
        double valor;

        Dados(int mes, int semana, double valor) {
            this.mes = mes;
            this.semana = semana;
            this.valor = valor;
        }

        Dados(int mes, int semana) {
            this.mes = mes;
            this.semana = semana;
            this.valor = 0;
        }
    }

    static Dados lerMesSemanaValor(Scanner sc) {
        System.out.println("Digite os itens a seguir");
        System.out.println("Mês");
        int mes = sc.nextInt();
        System.out.println("Semana");
        int semana = sc.nextInt();
        System.out.println("Valor");
        double valor = sc.nextDouble();

        return new Dados(mes, semana, valor);
    }

    static Dados lerMesSemana(Scanner sc) {
        System.out.println("Digite os itens a seguir");
        System.out.println("Mês");
        int mes = sc.nextInt();
        System.out.println("Semana");
        int semana = sc.nextInt();

        return new Dados(mes, semana);
    }

    static void mostrarMenu() {
        System.out.println("---------- MENU ---------");
        System.out.println("1 - Cadastrar / Alterar / Excluir Despesas");
        System.out.println("2 - Cadastrar / Alterar / Excluir Receitas");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Listar Meses");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void mostrarSubmenu(String tipo) {
        System.out.println("------ " + tipo.toUpperCase() + " ------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.print("Escolha: ");
    }

    static void gerenciar (MatrizFinanceira matriz, Scanner sc, String tipo) {
        mostrarSubmenu(tipo);
        int op = sc.nextInt();
        switch (op) {
            case 1 -> {
                Dados d = lerMesSemanaValor(sc);
                if (tipo.equals("Despesas")) {
                    matriz.cadastrarDespesa( d.mes, d.semana, d.valor);
                } else {
                    matriz.cadastrarReceita( d.mes, d.semana, d.valor);
                }
            }
            case 2 -> {
                Dados d = lerMesSemanaValor(sc);
                if (tipo.equals("Despesas")) {
                    matriz.alterarDespesa( d.mes, d.semana, d.valor);
                } else {
                    matriz.alterarReceita( d.mes, d.semana, d.valor);
                }
            }
            case 3 -> {
                Dados d = lerMesSemana(sc);
                if (tipo.equals("Despesas")) {
                    matriz.excluirDespesa( d.mes, d.semana);
                } else {
                    matriz.excluirReceita( d.mes, d.semana);
                }
            }

            default -> {
                System.out.println("Opção inválida");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrizFinanceira matriz = new MatrizFinanceira();
        boolean executando = true;

        while (executando) {
            mostrarMenu();
            try {
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 1, 2 -> gerenciar(matriz, sc, (opcao == 1 ? "Despesas" : "Receitas"));
                    case 3 -> matriz.verEstatisticas();
                    case 4 -> matriz.listarMeses();
                    case 5 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: você deve digitar um número!");
                sc.nextLine();
            }
        }
    }
}
