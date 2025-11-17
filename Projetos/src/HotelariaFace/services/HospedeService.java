package HotelariaFace.services;

import java.io.*;
import java.util.Scanner; // Permanece porque era usado na classe original (mas não é usado nos métodos agora)
// import Hotelaria.Utils; // Removido, pois não é mais necessário

public class HospedeService {

    // CAMINHO BASE: programacao-2-projetos/projetos/src/Hotelaria/data/hospedes.txt
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

    // GARANTE QUE OS ARQUIVOS EXISTAM
    private void inicializarArquivos() {
        try {
            File dataDir = new File(arquivoHospedes).getParentFile();
            if (!dataDir.exists()) dataDir.mkdirs();

            File arqHospedes = new File(arquivoHospedes);
            if (!arqHospedes.exists()) arqHospedes.createNewFile();

            File arqId = new File(arquivoId);
            // Uso o gravaId(0) em vez de arqId.createNewFile() para garantir que o arquivo
            // tenha um "0" inicial se for a primeira vez.
            if (!arqId.exists()) gravaId(0);

        } catch (IOException e) {
            System.out.println("Erro ao criar diretórios: " + e.getMessage());
        }
    }

    // Lê o último ID salvo
    private int lerId() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoId))) {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            // Em caso de erro (ex: arquivo vazio ou ID inválido), retorna 0
            return 0;
        }
    }

    // GRAVA O NOVO ID
    private void gravaId(int id) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoId))) {
            pw.println(id);
        } catch (IOException e) {
            System.out.println("Erro ao gravar ID: " + e.getMessage());
        }
    }

    // 🔧 1. NOVO CADASTRAR: Recebe todos os dados e não interage com o console.
    public void cadastrarHospede(String nome, String cpf, String rg, String celular, String email) {
        int id = lerId();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoHospedes, true))) {
            bw.write(id + ";" + nome + ";" + cpf + ";" + rg + ";" + celular + ";" + email);
            bw.newLine();
            gravaId(id + 1);
        } catch (IOException e) {
            // Mantendo o print APENAS em catch blocks para fins de log de erro
            System.out.println("Erro ao gravar hóspede: " + e.getMessage());
        }
    }


    // 2. Método listarHospedes() removido (ou comentado/oculto)
    // O método listarComoString() já está pronto para o Swing

    // LISTAR TODOS COMO STRING (OK para Swing)
    public String listarComoString() {
        File f = new File(arquivoHospedes);

        if (f.length() == 0) {
            return "Nenhum hóspede cadastrado.";
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                // Adiciona uma verificação básica para evitar ArrayIndexOutOfBoundsException
                if (dados.length >= 6) {
                    sb.append("ID: ").append(dados[0]).append("\n");
                    sb.append("Nome: ").append(dados[1]).append("\n");
                    sb.append("CPF: ").append(dados[2]).append("\n");
                    sb.append("RG: ").append(dados[3]).append("\n");
                    sb.append("Celular: ").append(dados[4]).append("\n");
                    sb.append("Email: ").append(dados[5]).append("\n\n");
                }
            }
        } catch (IOException e) {
            // Retorna uma mensagem de erro em string para o GUI
            return "Erro ao ler hóspedes.";
        }

        return sb.toString();
    }

    public boolean removerHospede(int idRemover) {

        File arquivo = new File(arquivoHospedes);
        File temp = new File(arquivo.getParent(), "temp.txt");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                // Adiciona uma verificação para evitar problemas com linhas mal-formatadas
                if (dados.length < 1) continue;

                int idLinha = Integer.parseInt(dados[0]);

                if (idLinha != idRemover) {
                    bw.write(linha);
                    bw.newLine();
                } else {
                    encontrado = true;
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao remover hóspede: " + e.getMessage());
            // Se houver um erro de IO/formato, não prossegue com a troca de arquivos
            return false;
        }

        // Tenta remover o arquivo original e renomear o temporário
        if (arquivo.delete() && temp.renameTo(arquivo)) {
            return encontrado; // Retorna true se encontrou e removeu, false se não encontrou
        } else {
            // Erro na operação de arquivo (delete ou rename)
            System.out.println("Erro na operação de arquivo ao remover hóspede.");
            // Tenta garantir que o arquivo temporário não permaneça se o rename falhar
            temp.delete();
            return false;
        }
    }

    public boolean apagarTodos() {
        File f = new File(arquivoHospedes);
        if (f.exists()) {
            try (PrintWriter pw = new PrintWriter(f)) {
                pw.print(""); // limpa o conteúdo
                gravaId(0);
                // System.out.println("🗑Todos os hóspedes foram apagados!"); // Removido
                return true;
            } catch (IOException e) {
                System.out.println("Erro ao apagar hóspedes: " + e.getMessage());
                return false;
            }
        }
        return false; // Retorna false se o arquivo nem existir
    }
}