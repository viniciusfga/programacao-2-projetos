package REVISAO_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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

    static Dados lerMesSemanaValor(Scanner sc) throws InputMismatchException {
        System.out.println("Digite os itens a seguir");
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Semana: ");
        int semana = sc.nextInt();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();

        return new Dados(mes, semana, valor);
    }

    static Dados lerMesSemana(Scanner sc) throws InputMismatchException {
        System.out.println("Digite os itens a seguir");
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Semana: ");
        int semana = sc.nextInt();

        return new Dados(mes, semana);
    }

    static void mostrarMenu() {
        System.out.println("\n---------- MENU ---------");
        System.out.println("1 - Cadastrar / Alterar / Excluir Despesas");
        System.out.println("2 - Cadastrar / Alterar / Excluir Receitas");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Listar Meses");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void mostrarSubmenu(String tipo) {
        System.out.println("\n------ " + tipo.toUpperCase() + " ------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.print("Escolha: ");
    }

    static void gerenciar(MatrizFinanceira matriz, Scanner sc, String tipo) throws InputMismatchException {
        mostrarSubmenu(tipo);
        int op = sc.nextInt();
        switch (op) {
            case 1 -> {
                Dados d = lerMesSemanaValor(sc);
                if (tipo.equals("Despesas"))
                    matriz.cadastrarDespesas(d.mes, d.semana, d.valor);
                else matriz.cadastrarReceitas(d.mes, d.semana, d.valor);
            }
            case 2 -> {
                Dados d = lerMesSemanaValor(sc);
                if (tipo.equals("Despesas"))
                    matriz.alterarDespesas(d.mes, d.semana, d.valor);
                else matriz.alterarReceitas(d.mes, d.semana, d.valor);
            }
            case 3 -> {
                Dados d = lerMesSemana(sc);
                if (tipo.equals("Despesas"))
                    matriz.excluirDespesas(d.mes, d.semana);
                else matriz.excluirReceitas(d.mes, d.semana);
            }
            default -> System.out.println("ERRO: Opção inválida");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrizFinanceira matriz = new MatrizFinanceira();

        boolean executando = true;

        while (executando) {
            try {
                mostrarMenu();
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> gerenciar(matriz, sc, "Despesas");
                    case 2 -> gerenciar(matriz, sc, "Receitas");
                    case 3 -> matriz.verEstatisticas();
                    case 4 -> matriz.listarMeses();
                    case 5 -> {
                        System.out.println("Saindo...");
                        executando = false;
                    }
                    default -> System.out.println("ERRO: Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Você deve digitar um número!");
                sc.nextLine(); // limpa entrada incorreta
            }
        }
    }
}
