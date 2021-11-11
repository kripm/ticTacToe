package myself.gui;

import myself.game.Board;
import myself.game.GameState;
import myself.game.Player;
import myself.game.EasyAI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class GamePanel extends JLayeredPane {

    Player player = new Player();
    EasyAI easyAI = new EasyAI();
    JLabel background = new JLabel();
    JLabel endScreen = new JLabel();
    ImageIcon grid = new ImageIcon("src/myself/gui/images/grid.png");
    ImageIcon imageX = new ImageIcon("src/myself/gui/images/X.png");
    Image image = imageX.getImage();
    Image newImg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
    ImageIcon smallX = new ImageIcon(newImg); // i stole this from Stack Overflow.
    ImageIcon imageO = new ImageIcon("src/myself/gui/images/O.png");
    Image image2 = imageO.getImage();
    Image newImg2 = image2.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
    ImageIcon smallO = new ImageIcon(newImg2);
    JLabel x1 = new JLabel(smallX);
    JLabel x2 = new JLabel(smallX);
    JLabel x3 = new JLabel(smallX);
    JLabel x4 = new JLabel(smallX);
    JLabel x5 = new JLabel(smallX);
    JLabel x6 = new JLabel(smallX);
    JLabel x7 = new JLabel(smallX);
    JLabel x8 = new JLabel(smallX);
    JLabel x9 = new JLabel(smallX);
    JLabel o1 = new JLabel(smallO);
    JLabel o2 = new JLabel(smallO);
    JLabel o3 = new JLabel(smallO);
    JLabel o4 = new JLabel(smallO);
    JLabel o5 = new JLabel(smallO);
    JLabel o6 = new JLabel(smallO);
    JLabel o7 = new JLabel(smallO);
    JLabel o8 = new JLabel(smallO);
    JLabel o9 = new JLabel(smallO);
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();

    GamePanel() {
        player.isX(true);
        easyAI.isX(false);

        x1.setOpaque(true);
        x1.setVisible(false);
        x1.setBounds(0, 0, 200, 200);
        x2.setOpaque(true);
        x2.setVisible(false);
        x2.setBounds(200, 0, 200, 200);
        x3.setOpaque(true);
        x3.setVisible(false);
        x3.setBounds(400, 0, 200, 200);
        x4.setOpaque(true);
        x4.setVisible(false);
        x4.setBounds(0, 200, 200, 200);
        x5.setOpaque(true);
        x5.setVisible(false);
        x5.setBounds(200, 200, 200, 200);
        x6.setOpaque(true);
        x6.setVisible(false);
        x6.setBounds(400, 200, 200, 200);
        x7.setOpaque(true);
        x7.setVisible(false);
        x7.setBounds(0, 400, 200, 200);
        x8.setOpaque(true);
        x8.setVisible(false);
        x8.setBounds(200, 400, 200, 200);
        x9.setOpaque(true);
        x9.setVisible(false);
        x9.setBounds(400, 400, 200, 200);
        o1.setOpaque(true);
        o1.setVisible(false);
        o1.setBounds(0, 0, 200, 200);
        o2.setOpaque(true);
        o2.setVisible(false);
        o2.setBounds(200, 0, 200, 200);
        o3.setOpaque(true);
        o3.setVisible(false);
        o3.setBounds(400, 0, 200, 200);
        o4.setOpaque(true);
        o4.setVisible(false);
        o4.setBounds(0, 200, 200, 200);
        o5.setOpaque(true);
        o5.setVisible(false);
        o5.setBounds(200, 200, 200, 200);
        o6.setOpaque(true);
        o6.setVisible(false);
        o6.setBounds(400, 200, 200, 200);
        o7.setOpaque(true);
        o7.setVisible(false);
        o7.setBounds(0, 400, 200, 200);
        o8.setOpaque(true);
        o8.setVisible(false);
        o8.setBounds(200, 400, 200, 200);
        o9.setOpaque(true);
        o9.setVisible(false);
        o9.setBounds(400, 400, 200, 200);
        b1.setContentAreaFilled(false);
        b1.setBounds(0, 0, 200, 200);
        b2.setContentAreaFilled(false);
        b2.setBounds(200, 0, 200, 200);
        b3.setContentAreaFilled(false);
        b3.setBounds(400, 0, 200, 200);
        b4.setContentAreaFilled(false);
        b4.setBounds(0, 200, 200, 200);
        b5.setContentAreaFilled(false);
        b5.setBounds(200, 200, 200, 200);
        b6.setContentAreaFilled(false);
        b6.setBounds(400, 200, 200, 200);
        b7.setContentAreaFilled(false);
        b7.setBounds(0, 400, 200, 200);
        b8.setContentAreaFilled(false);
        b8.setBounds(200, 400, 200, 200);
        b9.setContentAreaFilled(false);
        b9.setBounds(400, 400, 200, 200);

        background.setHorizontalAlignment(SwingConstants.CENTER);
        background.setVerticalAlignment(SwingConstants.CENTER);
        background.setIcon(grid);
        background.setOpaque(false);
        background.setLayout(null);
        background.setBounds(0, 0, 600, 600);

        endScreen.setLayout(null);
        endScreen.setBounds(0, 0, 600, 600);
        endScreen.setBackground(new Color(0f,0f,0f,.7f));
        endScreen.setVisible(false);

        add(endScreen);
        add(background);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(x1);
        add(x2);
        add(x3);
        add(x4);
        add(x5);
        add(x6);
        add(x7);
        add(x8);
        add(x9);
        add(o1);
        add(o2);
        add(o3);
        add(o4);
        add(o5);
        add(o6);
        add(o7);
        add(o8);
        add(o9);

        Board.start();
        guiUpdate();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(1)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(2)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(3)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(4)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(5)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(6)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }

            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(7)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(8)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });

        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(9)) {
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        easyAI.move();
                    }
                    guiUpdate();
                }
            }
        });
    }

    void guiUpdate() {
        int index = 1;
        for (char mark : Board.getGameBoard()) {
            if (mark == 'X') {
                switch (index) {
                    case 1:
                        x1.setVisible(true);
                        break;
                    case 2:
                        x2.setVisible(true);
                        break;
                    case 3:
                        x3.setVisible(true);
                        break;  
                    case 4:
                        x4.setVisible(true);
                        break;
                    case 5:
                        x5.setVisible(true);
                        break;
                    case 6:
                        x6.setVisible(true);
                        break;
                    case 7:
                        x7.setVisible(true);
                        break;    
                    case 8:
                        x8.setVisible(true);
                        break;   
                    case 9:
                        x9.setVisible(true);
                        break;               
                }
            } else if (mark == 'O') {
                switch (index) {
                    case 1:
                        o1.setVisible(true);
                        break;
                    case 2:
                        o2.setVisible(true);
                        break;
                    case 3:
                        o3.setVisible(true);
                        break;  
                    case 4:
                        o4.setVisible(true);
                        break;
                    case 5:
                        o5.setVisible(true);
                        break;
                    case 6:
                        o6.setVisible(true);
                        break;
                    case 7:
                        o7.setVisible(true);
                        break;    
                    case 8:
                        o8.setVisible(true);
                        break;   
                    case 9:
                        o9.setVisible(true);
                        break;   
                }
            }
        index++;
        }

        if (Board.getGameState() == GameState.O_WIN || Board.getGameState() == GameState.X_WIN || Board.getGameState() == GameState.DRAW) {
            endScreen.setOpaque(true);
            endScreen.setVerticalAlignment(SwingConstants.CENTER);
            endScreen.setHorizontalAlignment(SwingConstants.CENTER);
            endScreen.setFont(new Font ("Verdana", Font.ITALIC, 100));
            endScreen.setForeground(Color.RED);
            endScreen.setVisible(true);
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
            b6.setVisible(false);
            b7.setVisible(false);
            b8.setVisible(false);
            b9.setVisible(false);
            if (Board.getGameState() == GameState.O_WIN || Board.getGameState() == GameState.X_WIN || Board.getGameState() == GameState.DRAW) {
                endScreen.setText("X WINS");
            }
        }
    } 
}
