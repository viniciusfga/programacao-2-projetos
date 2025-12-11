package Hotelaria.services;

import Hotelaria.Utils;
import Hotelaria.models.Hospede;

import java.io.*;

public class HospedeService {

    private final String arquivoHospedes = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "hospedes.txt";

    private final String arquivoId = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "Hotelaria"
            + File.separator + "data"
            + File.separator + "idHospede.txt";

    public HospedeService() {
        inicializarArquivos();
    }

    private void inicializarArquivos() {
        try {
            File dir = new File(arquivoHospedes).getParentFile();
            if (!dir.exists()) dir.mkdirs();

            File hosp = new File(arquivoHospedes);
            if (!hosp.exists()) hosp.createNewFile();

            File id = new File(arquivoId);
            if (!id.exists()) gravaId(0);

        } catch (IOException e) {
            System.out.println("Erro ao criar diretórios: " + e.getMessage());
        }
    }

    private int lerId() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoId))) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) return 0;
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private void gravaId(int id) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoId))) {
            pw.println(id);
        } catch (IOException e) {
            System.out.println("Erro ao gravar ID: " + e.getMessage());
        }
    }

    private String hospedeParaLinha(Hospede h) {
        return h.id + ";" + h.nome + ";" + h.cpf + ";" + h.rg + ";" + h.celular + ";" + h.email;
    }

    private Hospede linhaParaHospede(String linha) {
        String[] d = linha.split(";");
        if (d.length < 6) return null;

        return new Hospede(
                Integer.parseInt(d[0]),
                d[1], d[2], d[3], d[4], d[5]
        );
    }

    /* ============================================================
       CADASTRAR
       ============================================================ */

    public void cadastrarHospede() {
        int id = lerId();

        System.out.println("\n--- Cadastro de Hóspede ---");

        String nome = Utils.lerString("Nome: ");
        String cpf = Utils.lerString("CPF: ");
        String rg = Utils.lerString("RG: ");
        String celular = Utils.lerString("Celular: ");
        String email = Utils.lerString("E-mail: ");

        Hospede h = new Hospede(id, nome, cpf, rg, celular, email);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoHospedes, true))) {
            bw.write(hospedeParaLinha(h));
            bw.newLine();
            gravaId(id + 1);
            System.out.println("\nHóspede cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar hóspede: " + e.getMessage());
        }
    }

    /* ============================================================
       LISTAR
       ============================================================ */

    public void listarHospedes() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Hóspedes ===");

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                Hospede h = linhaParaHospede(linha);
                if (h == null) continue;
                exibirHospede(h);
                System.out.println("------------------------");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler hóspedes: " + e.getMessage());
        }
    }

    /* ============================================================
       REMOVER
       ============================================================ */

    public void removerHospede() {
        File arquivo = new File(arquivoHospedes);

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        int idRemover = Utils.lerInt("Digite o ID para remover: ");

        File temp = new File(arquivo.getParent(), "temp.txt");
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                Hospede h = linhaParaHospede(linha);
                if (h == null) continue;

                if (h.id != idRemover) {
                    bw.write(hospedeParaLinha(h));
                    bw.newLine();
                } else {
                    encontrado = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
            return;
        }

        arquivo.delete();
        temp.renameTo(arquivo);

        if (encontrado)
            System.out.println("Hóspede removido com sucesso!");
        else
            System.out.println("Hóspede não encontrado!");
    }

    /* ============================================================
       APAGAR TODOS
       ============================================================ */

    public void apagarTodos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoHospedes))) {
            pw.print("");
            gravaId(0);
            System.out.println("Todos os hóspedes foram apagados!");
        } catch (IOException e) {
            System.out.println("Erro ao apagar: " + e.getMessage());
        }
    }

    /* ============================================================
       BUSCAR
       ============================================================ */

    public void buscarHospede() {
        File f = new File(arquivoHospedes);

        if (!f.exists() || f.length() == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.println("\n=== Buscar Hóspede ===");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar por Nome");

        int opcao = Utils.lerInt("Escolha: ");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;

            switch (opcao) {
                case 1:
                    int idBuscar = Utils.lerInt("Digite o ID: ");

                    while ((linha = br.readLine()) != null) {
                        Hospede h = linhaParaHospede(linha);
                        if (h == null) continue;

                        if (h.id == idBuscar) {
                            exibirHospede(h);
                            encontrado = true;
                            break;
                        }
                    }
                    break;

                case 2:
                    String nomeBuscar = Utils.lerString("Parte do nome: ").toLowerCase();

                    while ((linha = br.readLine()) != null) {
                        Hospede h = linhaParaHospede(linha);
                        if (h == null) continue;

                        if (h.nome.toLowerCase().contains(nomeBuscar)) {
                            exibirHospede(h);
                            encontrado = true;
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    return;
            }

        } catch (IOException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        if (!encontrado)
            System.out.println("Nenhum hóspede encontrado!");
    }

    /* ============================================================
       EXIBIR OBJETO
       ============================================================ */

    private void exibirHospede(Hospede h) {
        System.out.println("\nID: " + h.id);
        System.out.println("Nome: " + h.nome);
        System.out.println("CPF: " + h.cpf);
        System.out.println("RG: " + h.rg);
        System.out.println("Celular: " + h.celular);
        System.out.println("Email: " + h.email);
    }
}
