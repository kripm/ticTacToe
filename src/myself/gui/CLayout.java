package myself.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class CLayout {
    JPanel panelContainer = new JPanel();
    MenuPanel menu = new MenuPanel();
    MenuBotPanel botmenu = new MenuBotPanel();
    JButton botsButton = new JButton("Watch The Bots Fight Each Other");
    JButton playerButton = new JButton("Play Vs ...");
    CardLayout cl = new CardLayout();
    Font smallFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

    public CLayout() {
        JFrame frame = new JFrame("TicTacToe");
        ImageIcon image = new ImageIcon("src/myself/gui/Images/logo.png");

        panelContainer.setLayout(cl);
        panelContainer.add(menu, "1");
        panelContainer.add(botmenu, "2");

        botsButton.setContentAreaFilled(false);
        botsButton.setFont(smallFont);
        botsButton.setBounds(90, 450, 400, 50);

        playerButton.setContentAreaFilled(false);
        playerButton.setFont(smallFont);
        playerButton.setBounds(90, 450, 400, 50);

        menu.add(botsButton);
        botmenu.add(playerButton);

        cl.show(panelContainer, "1");

        botsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer, "2");
            }
        });

        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer, "1");
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(222, 224, 224));
        frame.add(panelContainer);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CLayout();
            }
        });
    }
}
