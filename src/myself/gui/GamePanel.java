package myself.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class GamePanel extends JLayeredPane {

    GamePanel() {
        JLabel background = new JLabel();
        ImageIcon grid = new ImageIcon("src/myself/gui/images/grid.png");

        background.setHorizontalAlignment(SwingConstants.CENTER);
        background.setVerticalAlignment(SwingConstants.CENTER);
        background.setIcon(grid);
        background.setOpaque(true);
        background.setLayout(null);
        background.setBounds(0, 0, 600, 600);

        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);

        add(background);
    }
}
