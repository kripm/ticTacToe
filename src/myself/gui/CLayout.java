package myself.gui;

import myself.game.Player;
import myself.game.AI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class CLayout {
    Player playerOne = new Player();
    AI ai;
    JPanel panelContainer = new JPanel();
    JPanel mainMenuPanel = new JPanel();
    JPanel playButtonPanel = new JPanel();
    PlayerVsBotMenu playerVsBotMenu = new PlayerVsBotMenu();
    BotVsBotMenu botVsBotMenu = new BotVsBotMenu();
    GamePanel playerVsBotGamePanel;
    GamePanel botVsBotGamePanel;
    GamePanel playerVsPlayerGamePanel = new GamePanel(new Player(), new Player());
    JButton playerVsBotButton = new JButton("Player vs Bot");
    JButton botVsBotButton = new JButton("Bot vs Bot");
    JButton playerVsPlayerButton = new JButton("Player vs Player");
    JButton playButtonA = new JButton("Play");
    JButton playButtonB = new JButton("Play");
    JButton backButton = new JButton("Back");
    CardLayout cl = new CardLayout();
    Font menuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);

    CLayout() {
        JFrame frame = new JFrame("TicTacToe");
        ImageIcon image = new ImageIcon("src/myself/gui/Images/logo.png");

        mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 50));
        mainMenuPanel.setBounds(0, 0, 600, 600);
        panelContainer.setLayout(cl);
        panelContainer.add(mainMenuPanel, "MainMenu");
        panelContainer.add(playerVsBotMenu, "PVBM");
        panelContainer.add(botVsBotMenu, "BVBM");
        panelContainer.add(playerVsPlayerGamePanel, "PVP");

        botVsBotButton.setContentAreaFilled(false);
        botVsBotButton.setFont(menuFont);

        playerVsBotButton.setContentAreaFilled(false);
        playerVsBotButton.setFont(menuFont);

        playerVsPlayerButton.setContentAreaFilled(false);
        playerVsPlayerButton.setFont(menuFont);

        playButtonA.setPreferredSize(new Dimension(300, 60));
        playButtonA.setBackground(Color.LIGHT_GRAY);
        playButtonA.setFont(menuFont);
        playButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        playButtonPanel.add(playButtonA);

        mainMenuPanel.add(playerVsBotButton);
        mainMenuPanel.add(botVsBotButton);
        mainMenuPanel.add(playerVsPlayerButton);
        playerVsBotMenu.add(backButton);
        botVsBotMenu.add(backButton);

        cl.show(panelContainer, "1");

        playerVsBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerVsBotMenu.add(playButtonPanel, BorderLayout.SOUTH);
                cl.show(panelContainer, "PVBM");

            }
        });

        botVsBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer, "BVBM");
            }
        });

        playerVsPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer, "PVP");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer, "MainMenu");
            }
        });

        playButtonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerVsBotGamePanel = new GamePanel(playerOne, playerVsBotMenu.getAI(),
                        playerVsBotMenu.getPlayerIsX());
                panelContainer.add(playerVsBotGamePanel, "PVBG");
                cl.show(panelContainer, "PVBG");
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(615, 639);
        frame.setIconImage(image.getImage());
        frame.add(panelContainer);
        frame.setLocationRelativeTo(null);
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
