package Datos;

import javax.swing.*;
import java.awt.*;

public class SacarScroll {
    JTextArea textArea = null;
    JScrollPane scroll = null;
    JFrame frame = null;

    public void mensajeScroll(String texto){
        textArea = new JTextArea();
        textArea.append(texto);
        scroll = new JScrollPane(textArea);
        frame = new JFrame();
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
