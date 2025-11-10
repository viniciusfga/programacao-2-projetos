package HotelariaV1.services;

import java.io.*;
import java.util.Scanner;
import HotelariaV1.models.Hospede;
import HotelariaV1.Utils;

public class HospedeService {

    // Caminho base: dentro de programacao-2-projetos/Projetos/HotelariaV1/data/
    private final String raiz = System.getProperty("user.dir")
            + File.separator + "Projetos"
            + File.separator + "src"
            + File.separator + "HotelariaV1"
            + File.separator + "data" + File.separator;

    private final String pastaHospedes = raiz + "hospedes" + File.separator;
    private final String arqIdHospede = raiz + "idHospede.txt";


    public HospedeService() {
        iniciarPastas();
        System.out.println("📁 Diretório base: " + raiz);
    }

    // GARANTE QUE AS PASTAS E ARQUIVOS EXISTAM
    private void iniciarPastas() {
        File dirRaiz = new File(raiz);
        if (!dirRaiz.exists()) dirRaiz.mkdirs();

        File dirHospedes = new File(pastaHospedes);
        if (!dirHospedes.exists()) dirHospedes.mkdirs();

        File arqId = new File(arqIdHospede);
        if (!arqId.exists()) gravaId(0);
    }

    // LÊ O ID ATUAL
    private int leId() {
        try (BufferedReader br = new BufferedReader(new FileReader(arqIdHospede))) {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            return 0;
        }
    }

    // GRAVA O NOVO ID
    private void gravaId(int id) {
        try (PrintWriter pw = new PrintWriter(arqIdHospede)) {
            pw.println(id);
        } catch (IOException e) {
            System.out.println("Erro ao atualizar ID.");
        }
    }

    // CADASTRAR HÓSPEDE
    public void cadastrarHospede() {
        int id = leId();
        Hospede h = new Hospede();

        System.out.println("\n--- Cadastro de Hóspede ---");
        h.id = id;
        h.nome = Utils.lerString("Nome: ");
        h.cpf = Utils.lerString("CPF: ");
        h.rg = Utils.lerString("RG: ");
        h.celular = Utils.lerString("Celular: ");
        h.email = Utils.lerString("E-mail: ");

        if (gravarHospede(h)) {
            gravaId(++id);
            System.out.println("\nHóspede cadastrado com sucesso!");
        } else {
            System.out.println("\nErro ao gravar hóspede!");
        }
    }

    // GRAVA HÓSPEDE EM ARQUIVO
    private boolean gravarHospede(Hospede h) {
        try (PrintWriter pw = new PrintWriter(pastaHospedes + h.id + ".txt")) {
            pw.println(h.id);
            pw.println(h.nome);
            pw.println(h.cpf);
            pw.println(h.rg);
            pw.println(h.celular);
            pw.println(h.email);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar hóspede: " + e.getMessage());
            return false;
        }
    }

    // LISTAR TODOS OS HÓSPEDES
    public void listarHospedes() {
        File dir = new File(pastaHospedes);
        String[] arquivos = dir.list();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        for (String nomeArq : arquivos) {
            File f = new File(pastaHospedes + nomeArq);
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                System.out.println("\n--- Hóspede ---");
                System.out.println("ID: " + br.readLine());
                System.out.println("Nome: " + br.readLine());
                System.out.println("CPF: " + br.readLine());
                System.out.println("RG: " + br.readLine());
                System.out.println("Celular: " + br.readLine());
                System.out.println("Email: " + br.readLine());
            } catch (Exception e) {
                System.out.println("Erro ao ler arquivo: " + e.getMessage());
            }
        }
    }

    // REMOVER HÓSPEDE
    public void removerHospede() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do hóspede para remover: ");
        int id = sc.nextInt();
        File f = new File(pastaHospedes + id + ".txt");

        if (f.exists()) {
            f.delete();
            System.out.println("Hóspede removido com sucesso!");
        } else {
            System.out.println("Hóspede não encontrado!");
        }
    }

    // APAGAR TODOS OS HÓSPEDES
    public void apagarTodos() {
        File dir = new File(pastaHospedes);
        File[] arquivos = dir.listFiles();

        if (arquivos == null) return;
        for (File f : arquivos) f.delete();

        gravaId(0);
        System.out.println("Todos os hóspedes foram removidos!");
    }
}
