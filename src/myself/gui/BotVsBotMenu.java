package myself.gui;

import myself.game.AI;
import myself.game.EasyAI;
import myself.game.HardAI;
import myself.game.MediumAI;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class BotVsBotMenu extends JPanel {
    final JPanel optionsPanel = new JPanel();
    final JPanel optionsTextPanel = new JPanel();
    final JPanel xBotPanel = new JPanel();
    final JPanel xBotPanel2 = new JPanel();
    final JPanel oBotPanel = new JPanel();
    final JPanel oBotPanel2 = new JPanel();
    final JLabel optionsText = new JLabel("Options:");
    final JLabel botIsXText = new JLabel("Player X difficulty:");
    final JLabel botIsOText = new JLabel("Player O difficulty:");
    final JLabel emptyLabel = new JLabel();
    final JRadioButton easyBotX = new JRadioButton("Easy");
    final JRadioButton mediumBotX = new JRadioButton("Medium");
    final JRadioButton hardBotX = new JRadioButton("Hard");
    final JRadioButton easyBotO = new JRadioButton("Easy");
    final JRadioButton mediumBotO = new JRadioButton("Medium");
    final JRadioButton hardBotO = new JRadioButton("Hard");
    final ButtonGroup botChoiceX = new ButtonGroup();
    final ButtonGroup botChoiceO = new ButtonGroup();
    final Font menuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
    final Font bigMenuFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
    AI aiX;
    AI aiO;

    BotVsBotMenu() {
        botIsXText.setFont(menuFont);
        botIsXText.setPreferredSize(new Dimension(800, 50));
        botIsXText.setHorizontalAlignment(SwingConstants.CENTER);
        botIsOText.setFont(menuFont);
        botIsOText.setPreferredSize(new Dimension(800, 50));
        botIsOText.setHorizontalAlignment(SwingConstants.CENTER);

        easyBotX.setPreferredSize(new Dimension(115, 50));
        easyBotX.setFont(menuFont);
        mediumBotX.setPreferredSize(new Dimension(140, 50));
        mediumBotX.setFont(menuFont);
        hardBotX.setPreferredSize(new Dimension(100, 50));
        hardBotX.setFont(menuFont);
        easyBotO.setPreferredSize(new Dimension(115, 50));
        easyBotO.setFont(menuFont);
        mediumBotO.setPreferredSize(new Dimension(140, 50));
        mediumBotO.setFont(menuFont);
        hardBotO.setPreferredSize(new Dimension(100, 50));
        hardBotO.setFont(menuFont);

        xBotPanel.add(botIsXText);
        xBotPanel2.add(easyBotX);
        xBotPanel2.add(mediumBotX);
        xBotPanel2.add(hardBotX);

        botChoiceX.add(easyBotX);
        botChoiceX.add(mediumBotX);
        botChoiceX.add(hardBotX);

        emptyLabel.setPreferredSize(new Dimension(600, 10));

        easyBotX.addActionListener(e -> aiX = new EasyAI());
        mediumBotX.addActionListener(e -> aiX = new MediumAI());
        hardBotX.addActionListener(e -> aiX = new HardAI());

        oBotPanel.add(botIsOText);
        oBotPanel2.add(easyBotO);
        oBotPanel2.add(mediumBotO);
        oBotPanel2.add(hardBotO);

        botChoiceO.add(easyBotO);
        botChoiceO.add(mediumBotO);
        botChoiceO.add(hardBotO);

        easyBotO.addActionListener(e -> aiO = new EasyAI());
        mediumBotO.addActionListener(e -> aiO = new MediumAI());
        hardBotO.addActionListener(e -> aiO = new HardAI());

        optionsText.setFont(bigMenuFont);
        optionsTextPanel.add(optionsText);
        optionsTextPanel.setPreferredSize(new Dimension(600, 120));
        optionsPanel.setBounds(0, 120, 600, 380);
        optionsPanel.add(xBotPanel);
        optionsPanel.add(xBotPanel2);
        optionsPanel.add(emptyLabel);
        optionsPanel.add(oBotPanel);
        optionsPanel.add(oBotPanel2);

        this.setLayout(new BorderLayout());
        this.setVisible(true);

        add(optionsTextPanel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
    }

    public AI getAIX() {
        return aiX;
    }

    public AI getAIO() {
        return aiO;
    }
}
