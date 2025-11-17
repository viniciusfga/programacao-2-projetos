package HotelariaFace;

import HotelariaFace.screens.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AppGUI extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    public AppGUI() {

        // CONFIGURAÇÕES DA JANELA
        setTitle("SISTEMA HOTELARIA - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        // PAINEL PRINCIPAL
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        // COMPONENTES
        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField(15);

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(15);

        btnEntrar = new JButton("Entrar");

        // AÇÃO DO BOTÃO
        btnEntrar.addActionListener(e -> validarLogin());
        // --- 🔑 IMPLEMENTAÇÃO DO ENTER KEY BINDING ---

        // 1. Define a tecla Enter
        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        // 2. Mapeia o Enter para o comando "clickEntrar" na janela inteira
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(enterKeyStroke, "clickEntrar");

        // 3. Associa o comando "clickEntrar" ao método validarLogin()
        getRootPane().getActionMap().put("clickEntrar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama a mesma lógica do botão
                validarLogin();
            }
        });

        // ADICIONANDO COMPONENTES NA TELA
        c.gridx = 0; c.gridy = 0;
        painel.add(lblUsuario, c);

        c.gridx = 1; c.gridy = 0;
        painel.add(txtUsuario, c);

        c.gridx = 0; c.gridy = 1;
        painel.add(lblSenha, c);

        c.gridx = 1; c.gridy = 1;
        painel.add(txtSenha, c);

        c.gridx = 1; c.gridy = 2;
        painel.add(btnEntrar, c);

        add(painel);
        setVisible(true);
    }

    // MÉTODO PARA VALIDAR LOGIN
    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.equals("admin") && senha.equals("123")) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            abrirSistema();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
        }
    }

    // ABRE A PRÓXIMA TELA
    private void abrirSistema() {
        new TelaPrincipal(); // abre o menu
        dispose();           // fecha login
    }

    public static void main(String[] args) {
        new AppGUI();
    }
}
