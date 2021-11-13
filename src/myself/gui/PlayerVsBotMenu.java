package myself.gui;

import myself.game.AI;
import myself.game.EasyAI;
import myself.game.HardAI;
import myself.game.MediumAI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PlayerVsBotMenu extends JPanel {
    final JPanel optionsPanel = new JPanel();
    final JPanel optionsTextPanel = new JPanel();
    final JLabel optionsText = new JLabel("Options:");
    final JPanel playingAsPanel = new JPanel();
    final JPanel playingAsPanel2 = new JPanel();
    final JPanel playingAgainstPanel = new JPanel();
    final JPanel playingAgainstPanel2 = new JPanel();
    final JLabel playingAsText = new JLabel("Playing as:");
    final JLabel playingAgainstText = new JLabel("Bot difficulty:");
    final JLabel emptyLabel = new JLabel();
    final JRadioButton isX = new JRadioButton("X");
    final JRadioButton isO = new JRadioButton("O");
    final JRadioButton easyBot = new JRadioButton("Easy");
    final JRadioButton mediumBot = new JRadioButton("Medium");
    final JRadioButton hardBot = new JRadioButton("Hard");
    final ButtonGroup xOrO = new ButtonGroup();
    final ButtonGroup botChoice = new ButtonGroup();
    final Font menuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
    final Font bigMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
    boolean playerIsX;
    AI opponent;

    PlayerVsBotMenu() {
        playingAsText.setFont(menuFont);
        playingAsText.setPreferredSize(new Dimension(700, 50));
        playingAsText.setHorizontalAlignment(SwingConstants.CENTER);
        playingAgainstText.setFont(menuFont);
        playingAgainstText.setPreferredSize(new Dimension(700, 50));
        playingAgainstText.setHorizontalAlignment(SwingConstants.CENTER);

        isX.setPreferredSize(new Dimension(50, 50));
        isX.setFont(menuFont);
        isO.setPreferredSize(new Dimension(50, 50));
        isO.setFont(menuFont);
        xOrO.add(isX);
        xOrO.add(isO);
        easyBot.setPreferredSize(new Dimension(120, 50));
        easyBot.setFont(menuFont);
        mediumBot.setPreferredSize(new Dimension(145, 50));
        mediumBot.setFont(menuFont);
        hardBot.setPreferredSize(new Dimension(100, 50));
        hardBot.setFont(menuFont);
        botChoice.add(easyBot);
        botChoice.add(mediumBot);
        botChoice.add(hardBot);

        playingAsPanel.add(playingAsText);
        playingAsPanel2.add(isX);
        playingAsPanel2.add(isO);

        emptyLabel.setPreferredSize(new Dimension(600, 10));

        isX.addActionListener(e -> playerIsX = true);
        isO.addActionListener(e -> playerIsX = false);

        playingAgainstPanel.add(playingAgainstText);
        playingAgainstPanel2.add(easyBot);
        playingAgainstPanel2.add(mediumBot);
        playingAgainstPanel2.add(hardBot);

        easyBot.addActionListener(e -> opponent = new EasyAI());
        mediumBot.addActionListener(e -> opponent = new MediumAI());
        hardBot.addActionListener(e -> opponent = new HardAI());

        optionsText.setFont(bigMenuFont);
        optionsTextPanel.add(optionsText);
        optionsTextPanel.setPreferredSize(new Dimension(600, 140));
        optionsPanel.setBounds(0, 140, 600, 360);
        optionsPanel.add(playingAsPanel);
        optionsPanel.add(playingAsPanel2);
        optionsPanel.add(emptyLabel);
        optionsPanel.add(playingAgainstPanel);
        optionsPanel.add(playingAgainstPanel2);

        this.setLayout(new BorderLayout());
        this.setVisible(true);

        add(optionsTextPanel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
    }

    public boolean getPlayerIsX() {
        return playerIsX;
    }

    public AI getAI() {
        return opponent;
    }
}
