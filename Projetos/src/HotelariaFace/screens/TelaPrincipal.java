package HotelariaFace.screens;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {

        setTitle("Sistema Hotelaria");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botões do menu
        JButton btnHospedes = new JButton("Gerenciar Hóspedes");
        JButton btnQuartos = new JButton("Gerenciar Quartos");
        JButton btnReservas = new JButton("Gerenciar Reservas");
        JButton btnSair = new JButton("Sair");

        // Ações dos botões ============================
        btnHospedes.addActionListener(e -> new HotelariaFace.telas.TelaHospedes());
        btnQuartos.addActionListener(e -> new TelaQuartos());
        btnReservas.addActionListener(e -> new TelaReservas());
        btnSair.addActionListener(e -> System.exit(0));
        // ==============================================

        painel.add(btnHospedes);
        painel.add(btnQuartos);
        painel.add(btnReservas);
        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }
}
