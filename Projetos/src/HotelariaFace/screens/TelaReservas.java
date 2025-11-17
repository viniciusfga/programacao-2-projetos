package HotelariaFace.screens;

import javax.swing.*;

public class TelaReservas extends JFrame {

    public TelaReservas() {
        setTitle("Gerenciar Reservas");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        JTextArea area = new JTextArea("Aqui você irá colocar:\n- Criar Reserva\n- Cancelar\n- Listar\n...");
        area.setEditable(false);

        add(new JScrollPane(area));
        setVisible(true);
    }
}
