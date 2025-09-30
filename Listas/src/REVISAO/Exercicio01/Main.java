package REVISAO.Exercicio01;

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

    // Classe auxiliar para guardar os dados
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

    // Lê mês/semana/valor
    static Dados lerMesSemanaValor(Scanner sc) {
        System.out.println("Digite os itens a seguir");
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Semana: ");
        int semana = sc.nextInt();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        return new Dados(mes, semana, valor);
    }

    // Lê apenas mês/semana
    static Dados lerMesSemana(Scanner sc) {
        System.out.println("Digite os itens a seguir");
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Semana: ");
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

    static void submenuDespesas() {
        System.out.println("---------- SUBMENU DESPESAS ---------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.print("Escolha uma opção: ");
    }

    static void submenuReceitas() {
        System.out.println("---------- SUBMENU RECEITAS ---------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrizFinanceira matriz = new MatrizFinanceira();

        while (true) {
            mostrarMenu();

            try {
                int escolhaMenu = sc.nextInt();
                int escolhaSubMenu;

                switch (escolhaMenu) {
                    case 1: // despesas
                        submenuDespesas();
                        escolhaSubMenu = sc.nextInt();
                        switch (escolhaSubMenu) {
                            case 1:
                                Dados d1 = lerMesSemanaValor(sc);
                                matriz.cadastrarDespesas(d1.mes, d1.semana, d1.valor);
                                break;
                            case 2:
                                Dados d2 = lerMesSemanaValor(sc);
                                matriz.alterarDespesas(d2.mes, d2.semana, d2.valor);
                                break;
                            case 3:
                                Dados d3 = lerMesSemana(sc);
                                matriz.excluirDespesas(d3.mes, d3.semana);
                                break;
                            default:
                                System.out.println("Opção Inválida");
                                break;
                        }
                        break;

                    case 2: // receitas
                        submenuReceitas();
                        escolhaSubMenu = sc.nextInt();
                        switch (escolhaSubMenu) {
                            case 1:
                                Dados r1 = lerMesSemanaValor(sc);
                                matriz.cadastrarReceitas(r1.mes, r1.semana, r1.valor);
                                break;
                            case 2:
                                Dados r2 = lerMesSemanaValor(sc);
                                matriz.alterarReceitas(r2.mes, r2.semana, r2.valor);
                                break;
                            case 3:
                                Dados r3 = lerMesSemana(sc);
                                matriz.excluirReceitas(r3.mes, r3.semana);
                                break;
                            default:
                                System.out.println("Opção Inválida");
                                break;
                        }
                        break;

                    case 3:
                        matriz.verEstatisticas();
                        break;
                    case 4:
                        matriz.listarMeses();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: você deve digitar um número!");
                sc.nextLine();
            }
        }
    }
}
