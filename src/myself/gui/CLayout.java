package myself.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class CLayout {
    JFrame frame = new JFrame("TicTacToe");
    JPanel panelContainer = new JPanel();
    MenuPanel menu = new MenuPanel();
    
    CLayout() {
        

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TicTacToe");
        ImageIcon image = new ImageIcon("src/myself/gui/Images/logo.png");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(222, 224, 224));

        CLayout cl = new CLayout();

        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
