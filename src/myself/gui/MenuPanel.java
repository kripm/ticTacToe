package myself.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Cursor;
import java.awt.Font;

public class MenuPanel extends JPanel {

    MenuPanel() {
        ImageIcon imageX = new ImageIcon("src/myself/gui/Images/X.png");
        Image image = imageX.getImage(); 
        Image newImg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon smallX = new ImageIcon(newImg); // i stole this from Stack Overflow.

        ImageIcon imageO = new ImageIcon("src/myself/gui/Images/O.png");
        Image image2 = imageO.getImage();
        Image newImg2 = image2.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        ImageIcon smallO = new ImageIcon(newImg2);

        JLabel text = new JLabel("Choose:");
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
        JButton xButton = new JButton(smallX);
        JButton oButton = new JButton(smallO);
        

        text.setLayout(null);
        text.setFont(f1);
        text.setBounds(250, 90, 100, 200);

        xButton.setContentAreaFilled(false);
        xButton.setLayout(null);
        xButton.setBounds(120, 220, 120, 120);
        xButton.setCursor(new Cursor (Cursor.HAND_CURSOR));

        oButton.setContentAreaFilled(false);
        oButton.setLayout(null);
        oButton.setBounds(350, 220, 120, 120);
        oButton.setCursor(new Cursor (Cursor.HAND_CURSOR));
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        this.setLocation(0, 0);

        add(text);
        add(xButton);
        add(oButton);
    }
}
