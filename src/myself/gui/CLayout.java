package myself.gui;

import myself.game.AI;
import myself.game.Player;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class CLayout {
    Player playerOne = new Player();
    AI ai;
    JPanel panelContainer = new JPanel();
    JPanel mainMenuPanel = new JPanel();
    JPanel mainMenuPanelCenter = new JPanel();
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
    static JButton menuButton = new JButton("Menu");
    static JButton retryButtonA = new JButton("Retry");
    static JButton retryButtonB = new JButton("Retry");
    static JButton retryButtonC = new JButton("Retry");
    JLabel ticTacToe = new JLabel("<HTML><I><U>TicTacToe</U></I></HTML>");
    CardLayout cl = new CardLayout();
    Font smallerMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    Font smallMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
    Font menuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
    Font bigMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 65);

    CLayout() {
        JFrame frame = new JFrame("TicTacToe");
        ImageIcon image = new ImageIcon("src/myself/gui/images/logo.png");

        ticTacToe.setFont(bigMenuFont);
        mainMenuPanelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 75));
        mainMenuPanelCenter.setPreferredSize(new Dimension(600, 500));
        mainMenuPanel.add(ticTacToe, BorderLayout.NORTH);
        mainMenuPanel.add(mainMenuPanelCenter, BorderLayout.CENTER);
        mainMenuPanel.setBounds(0, 0, 600, 600);
        panelContainer.setLayout(cl);
        panelContainer.add(mainMenuPanel, "MainMenu");
        panelContainer.add(playerVsBotMenu, "PVBM");
        panelContainer.add(botVsBotMenu, "BVBM");
        panelContainer.add(playerVsPlayerGamePanel, "PVPG");

        botVsBotButton.setContentAreaFilled(false);
        botVsBotButton.setFont(menuFont);

        playerVsBotButton.setContentAreaFilled(false);
        playerVsBotButton.setFont(menuFont);

        playerVsPlayerButton.setContentAreaFilled(false);
        playerVsPlayerButton.setFont(menuFont);

        playButtonA.setPreferredSize(new Dimension(300, 60));
        playButtonA.setBackground(Color.LIGHT_GRAY);
        playButtonA.setFont(smallMenuFont);
        playButtonB.setPreferredSize(new Dimension(300, 60));
        playButtonB.setBackground(Color.LIGHT_GRAY);
        playButtonB.setFont(smallMenuFont);

        backButton.setContentAreaFilled(false);
        backButton.setFont(smallerMenuFont);
        backButton.setPreferredSize(new Dimension(100, 50));

        playButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        playButtonPanel.setLayout(new FlowLayout(0, 27, 0));
        playButtonPanel.add(backButton);

        mainMenuPanelCenter.add(playerVsBotButton);
        mainMenuPanelCenter.add(botVsBotButton);
        mainMenuPanelCenter.add(playerVsPlayerButton);

        cl.show(panelContainer, "1");

        playerVsBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonPanel.remove(playButtonB);
                playButtonPanel.add(playButtonA);
                playerVsBotMenu.add(playButtonPanel, BorderLayout.SOUTH);
                cl.show(panelContainer, "PVBM");
            }
        });

        botVsBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonPanel.remove(playButtonA);
                playButtonPanel.add(playButtonB);
                botVsBotMenu.add(playButtonPanel, BorderLayout.SOUTH);
                cl.show(panelContainer, "BVBM");
            }
        });

        playerVsPlayerButton.addActionListener(e -> cl.show(panelContainer, "PVPG"));
        backButton.addActionListener(e -> cl.show(panelContainer, "MainMenu"));
        menuButton.addActionListener(e -> cl.show(panelContainer, "MainMenu"));

        playButtonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerVsBotGamePanel = new GamePanel(playerOne, playerVsBotMenu.getAI(),
                        playerVsBotMenu.getPlayerIsX());
                panelContainer.add(playerVsBotGamePanel, "PVBG");
                cl.show(panelContainer, "PVBG");
            }
        });

        retryButtonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerVsBotGamePanel = new GamePanel(playerOne, playerVsBotMenu.getAI(),
                        playerVsBotMenu.getPlayerIsX());
                panelContainer.add(playerVsBotGamePanel, "PVBG");
                cl.show(panelContainer, "PVBG");
            }
        });

        playButtonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botVsBotGamePanel = new GamePanel(botVsBotMenu.getAIX(), botVsBotMenu.getAIO());
                panelContainer.add(botVsBotGamePanel, "BVBG");
                cl.show(panelContainer, "BVBG");
            }
        });

        retryButtonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botVsBotGamePanel = new GamePanel(botVsBotMenu.getAIX(), botVsBotMenu.getAIO());
                panelContainer.add(botVsBotGamePanel, "BVBG");
                cl.show(panelContainer, "BVBG");
            }
        });

        retryButtonC.addActionListener(e -> cl.show(panelContainer, "PVPG"));

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
