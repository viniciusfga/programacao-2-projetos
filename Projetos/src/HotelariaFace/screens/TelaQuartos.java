package HotelariaFace.screens;

import javax.swing.*;

public class TelaQuartos extends JFrame {

    public TelaQuartos() {
        setTitle("Gerenciar Quartos");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        JTextArea area = new JTextArea("Aqui você irá colocar:\n- Cadastrar Quarto\n- Listar\n- Marcar Ocupado/Livre\n...");
        area.setEditable(false);

        add(new JScrollPane(area));
        setVisible(true);
    }
}
