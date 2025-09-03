package Lista02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> estoque = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Sistema de Estoque ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consome quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String novo = sc.nextLine();
                    estoque.add(novo);
                    System.out.println("Produto adicionado!");
                    break;
                case 2:
                    System.out.print("Nome do produto a remover: ");
                    String remover = sc.nextLine();
                    if (estoque.remove(remover)) {
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Produtos no estoque:");
                    for (String produto : estoque) {
                        System.out.println("- " + produto);
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
