package myself.gui;

import myself.game.Board;
import myself.game.GameState;
import myself.game.Player;
import myself.game.AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class GamePanel extends JLayeredPane {

    JLabel backgroundGrid = new JLabel();
    JPanel endScreen = new JPanel();
    ImageIcon grid = new ImageIcon("src/myself/gui/images/grid.png");
    ImageIcon imageX = new ImageIcon("src/myself/gui/images/X.png");
    Image image = imageX.getImage();
    Image newImg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
    ImageIcon smallX = new ImageIcon(newImg); // i stole this from Stack Overflow.
    ImageIcon imageO = new ImageIcon("src/myself/gui/images/O.png");
    Image image2 = imageO.getImage();
    Image newImg2 = image2.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
    ImageIcon smallO = new ImageIcon(newImg2);
    JLabel oWinText = new JLabel("O WINS");
    JLabel xWinText = new JLabel("X WINS");
    JLabel drawText = new JLabel("DRAW");
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
    Timer firstAI;
    Timer secondAI;
    boolean pvb;
    boolean bvb;
    boolean pvp;

    GamePanel(Player player, AI ai, boolean playerX) {
        createPanel();
        pvb = true;

        if (playerX) {
            player.isX(true);
            ai.isX(false);
        } else {
            player.isX(false);
            ai.isX(true);
        }

        Board.start();

        if (!playerX) {
            ai.move();
            (new Thread(new GuiWait())).start();
        }

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(1)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(2)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(3)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(4)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(5)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(6)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }

            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(7)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(8)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });

        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.move(9)) {
                    guiUpdate();
                    if (Board.getGameState() == GameState.UNFINISHED) {
                        ai.move();
                    }
                    (new Thread(new GuiWait())).start();
                    checkEnd();
                }
            }
        });
    }

    class GuiWait implements Runnable {

        public void run() {
            try {
                Thread.sleep(200);
                guiUpdate();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

    }

    GamePanel(AI ai, AI aii) {
        int delay = 2000;

        createPanel();
        bvb = true;
        Board.start();
        ai.isX(true);
        aii.isX(false);

        ActionListener aiMove = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ai.move();
                guiUpdate();
                if (Board.getGameState() != GameState.UNFINISHED) {
                    checkEnd();
                    firstAI.stop();
                    secondAI.stop();
                }
            }
        };

        ActionListener aiiMove = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aii.move();
                guiUpdate();
                if (Board.getGameState() != GameState.UNFINISHED) {
                    checkEnd();
                    firstAI.stop();
                    secondAI.stop();
                }
            }
        };

        firstAI = new Timer(delay, aiMove);
        firstAI.setInitialDelay(0);
        firstAI.start();
        secondAI = new Timer(delay, aiiMove);
        secondAI.setInitialDelay(1000);
        secondAI.start();
    }

    GamePanel(Player playerOne, Player playerTwo) {
        createPanel();
        pvp = true;
        Board.start();
        playerOne.isX(true);
        playerTwo.isX(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(1);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(1);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(2);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(2);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(3);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(3);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(4);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(4);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(5);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(5);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(6);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(6);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(7);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(7);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(8);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(8);
                }
                guiUpdate();
                checkEnd();
            }
        });

        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.getTurn() == 1) {
                    playerOne.move(9);

                } else if (Board.getTurn() == 0) {
                    playerTwo.move(9);
                }
                guiUpdate();
                checkEnd();
            }
        });
    }

    void createPanel() {
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

        backgroundGrid.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundGrid.setVerticalAlignment(SwingConstants.CENTER);
        backgroundGrid.setIcon(grid);
        backgroundGrid.setOpaque(false);
        backgroundGrid.setLayout(null);
        backgroundGrid.setBounds(0, 0, 600, 600);

        endScreen.setLayout(null);
        endScreen.setBounds(0, 0, 600, 600);
        endScreen.setBackground(new Color(0f, 0f, 0f, .7f));
        endScreen.setVisible(false);

        // CLayout.backButton.setBounds(195, 360, 100, 40);

        add(endScreen);
        add(backgroundGrid);
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
    }

    void checkEnd() {
        if (Board.getGameState() == GameState.O_WIN || Board.getGameState() == GameState.X_WIN
                || Board.getGameState() == GameState.DRAW) {
            CLayout.menuButton.setBounds(107, 335, 180, 30);
            CLayout.menuButton.setBackground(Color.LIGHT_GRAY);
            endScreen.add(CLayout.menuButton);
            if (pvb) {
                CLayout.retryButtonA.setBounds(307, 335, 190, 30);
                CLayout.retryButtonA.setBackground(Color.LIGHT_GRAY);
                endScreen.add(CLayout.retryButtonA);
            } else if (bvb) {
                CLayout.retryButtonB.setBounds(307, 335, 190, 30);
                CLayout.retryButtonB.setBackground(Color.LIGHT_GRAY);
                endScreen.add(CLayout.retryButtonB);
            } else if (pvp) {
                CLayout.retryButtonC.setBounds(307, 335, 190, 30);
                CLayout.retryButtonC.setBackground(Color.LIGHT_GRAY);
                endScreen.add(CLayout.retryButtonC);
            }
            endScreen.setOpaque(true);
            endScreen.setForeground(Color.BLUE);
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
            if (Board.getGameState() == GameState.X_WIN) {
                xWinText.setBounds(107, 220, 400, 85);
                xWinText.setFont(new Font("Verdana", Font.ITALIC, 100));
                xWinText.setForeground(Color.WHITE);
                endScreen.add(xWinText);
            } else if (Board.getGameState() == GameState.O_WIN) {
                oWinText.setBounds(107, 220, 400, 85);
                oWinText.setFont(new Font("Verdana", Font.ITALIC, 100));
                oWinText.setForeground(Color.WHITE);
                endScreen.add(oWinText);
            } else if (Board.getGameState() == GameState.DRAW) {
                drawText.setBounds(150, 220, 400, 85);
                drawText.setFont(new Font("Verdana", Font.ITALIC, 100));
                drawText.setForeground(Color.WHITE);
                endScreen.add(drawText);
            }
        }
    }
}
