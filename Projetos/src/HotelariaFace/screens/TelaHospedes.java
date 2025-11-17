package HotelariaFace.telas;

import HotelariaFace.services.HospedeService;

import javax.swing.*;
import java.awt.*;

public class TelaHospedes extends JFrame {

    private HospedeService service;

    public TelaHospedes() {
        // CORREÇÃO 1: Inicializa o service corretamente
        this.service = new HospedeService();

        setTitle("Gerenciar Hóspedes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Botões das operações
        JButton btnCadastrar = new JButton("Cadastrar Hóspede");
        JButton btnListar = new JButton("Listar Hóspedes");
        JButton btnRemover = new JButton("Remover Hóspede");
        JButton btnApagarTodos = new JButton("Apagar Todos");
        JButton btnFechar = new JButton("Fechar");

        // Ações
        btnCadastrar.addActionListener(e -> cadastrar());
        btnListar.addActionListener(e -> listar());
        btnRemover.addActionListener(e -> remover());
        btnApagarTodos.addActionListener(e -> apagarTodos());
        btnFechar.addActionListener(e -> dispose());

        // Adicionando ao painel
        panel.add(btnCadastrar);
        panel.add(btnListar);
        panel.add(btnRemover);
        panel.add(btnApagarTodos);
        panel.add(btnFechar);

        add(panel);
        setVisible(true);
    }


    // ---------------------------------------------------
    // MÉTODOS DE AÇÃO (Agora usam JOptionPane para input/output)
    // ---------------------------------------------------

    private void cadastrar() {
        // NOVO CADASTRO: Coleta os 5 campos via GUI (JOptionPane)
        String nome = JOptionPane.showInputDialog(this, "Nome:");
        if (nome == null || nome.trim().isEmpty()) return;

        String cpf = JOptionPane.showInputDialog(this, "CPF:");
        if (cpf == null || cpf.trim().isEmpty()) return;

        String rg = JOptionPane.showInputDialog(this, "RG:");
        if (rg == null || rg.trim().isEmpty()) return;

        String celular = JOptionPane.showInputDialog(this, "Celular:");
        if (celular == null || celular.trim().isEmpty()) return;

        String email = JOptionPane.showInputDialog(this, "Email:");
        if (email == null || email.trim().isEmpty()) return;

        // Chama o service com 5 argumentos (como exigido)
        service.cadastrarHospede(nome, cpf, rg, celular, email);

        JOptionPane.showMessageDialog(this, "Hóspede cadastrado com sucesso!");
    }

    private void listar() {
        JTextArea area = new JTextArea(30, 60);
        area.setEditable(false);
        // Garante que o texto será formatado
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        String lista = service.listarComoString();

        area.setText(lista);

        JOptionPane.showMessageDialog(this, new JScrollPane(area),
                "Lista de Hóspedes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void remover() {
        String idStr = JOptionPane.showInputDialog(this, "ID do Hóspede para remover:");
        if (idStr == null || idStr.trim().isEmpty()) return;

        try {
            int id = Integer.parseInt(idStr);

            // Chama o service e usa o retorno booleano para dar feedback ao usuário
            boolean removido = service.removerHospede(id);

            if (removido) {
                JOptionPane.showMessageDialog(this, "Hóspede removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro: Hóspede com ID " + id + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido. Por favor, digite um número.");
        }
    }

    private void apagarTodos() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja apagar TODOS os hóspedes? Esta ação é irreversível.",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            // Chama o service e usa o retorno booleano para dar feedback ao usuário
            boolean sucesso = service.apagarTodos();

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Todos os hóspedes foram apagados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao apagar hóspedes.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}