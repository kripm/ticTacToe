package myself.gui;

import myself.game.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class CLayout {
    final Player playerOne = new Player();
    final JPanel panelContainer = new JPanel();
    final JPanel mainMenuPanel = new JPanel();
    final JPanel mainMenuPanelCenter = new JPanel();
    final JPanel playButtonPanel = new JPanel();
    final PlayerVsBotMenu playerVsBotMenu = new PlayerVsBotMenu();
    final BotVsBotMenu botVsBotMenu = new BotVsBotMenu();
    GamePanel playerVsBotGamePanel;
    GamePanel botVsBotGamePanel;
    GamePanel playerVsPlayerGamePanel;
    final JButton playerVsBotButton = new JButton("Player vs Bot");
    final JButton botVsBotButton = new JButton("Bot vs Bot");
    final JButton playerVsPlayerButton = new JButton("Player vs Player");
    final JButton playButtonA = new JButton("Play");
    final JButton playButtonB = new JButton("Play");
    final JButton backButton = new JButton("Back");
    static final JButton menuButton = new JButton("Menu");
    static final JButton retryButtonA = new JButton("Retry");
    static final JButton retryButtonB = new JButton("Retry");
    static final JButton retryButtonC = new JButton("Retry");
    final JLabel ticTacToe = new JLabel("<HTML><I><U>TicTacToe</U></I></HTML>");
    final CardLayout cl = new CardLayout();
    final Font smallerMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    final Font smallMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
    final Font menuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
    final Font bigMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 65);

    CLayout() {
        JFrame frame = new JFrame("TicTacToe");
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png")));

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

        playerVsBotButton.addActionListener(e -> {
            playButtonPanel.remove(playButtonB);
            playButtonPanel.add(playButtonA);
            playerVsBotMenu.add(playButtonPanel, BorderLayout.SOUTH);
            cl.show(panelContainer, "PVBM");
        });

        botVsBotButton.addActionListener(e -> {
            playButtonPanel.remove(playButtonA);
            playButtonPanel.add(playButtonB);
            botVsBotMenu.add(playButtonPanel, BorderLayout.SOUTH);
            cl.show(panelContainer, "BVBM");
        });

        playerVsPlayerButton.addActionListener(e -> {
            playerVsPlayerGamePanel = new GamePanel(new Player(), new Player());
            panelContainer.add(playerVsPlayerGamePanel, "PVPG");
            cl.show(panelContainer, "PVPG");
        });

        backButton.addActionListener(e -> cl.show(panelContainer, "MainMenu"));
        menuButton.addActionListener(e -> cl.show(panelContainer, "MainMenu"));

        playButtonA.addActionListener(e -> {
            playerVsBotGamePanel = new GamePanel(playerOne, playerVsBotMenu.getAI(),
                    playerVsBotMenu.getPlayerIsX());
            panelContainer.add(playerVsBotGamePanel, "PVBG");
            cl.show(panelContainer, "PVBG");
        });

        retryButtonA.addActionListener(e -> {
            playerVsBotGamePanel = new GamePanel(playerOne, playerVsBotMenu.getAI(),
                    playerVsBotMenu.getPlayerIsX());
            panelContainer.add(playerVsBotGamePanel, "PVBG");
            cl.show(panelContainer, "PVBG");
        });

        playButtonB.addActionListener(e -> {
            botVsBotGamePanel = new GamePanel(botVsBotMenu.getAIX(), botVsBotMenu.getAIO());
            panelContainer.add(botVsBotGamePanel, "BVBG");
            cl.show(panelContainer, "BVBG");
        });

        retryButtonB.addActionListener(e -> {
            botVsBotGamePanel = new GamePanel(botVsBotMenu.getAIX(), botVsBotMenu.getAIO());
            panelContainer.add(botVsBotGamePanel, "BVBG");
            cl.show(panelContainer, "BVBG");
        });

        retryButtonC.addActionListener(e -> {
            playerVsPlayerGamePanel = new GamePanel(new Player(), new Player());
            panelContainer.add(playerVsPlayerGamePanel, "PVPG");
            cl.show(panelContainer, "PVPG");
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
        javax.swing.SwingUtilities.invokeLater(() -> new CLayout());
    }
}
