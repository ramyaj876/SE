/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author acer
 */
public class DeadFrame {
    JFrame f;
    String U;
    int score;
    DeadFrame(String user)
    {
        f = new JFrame();
        f.add(new JLabel(new ImageIcon("D:/Images/4.gif")));
        f.setSize(1366,768);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        U = user;
    }

    void assignFFmap(short map[][])
    {

    }

    void Score(int s)
    {
        Disp D = new Disp();
        this.score = s;
        f.add(D);
        DB db = new DB();
        db.connDB();
        f.setVisible(true);
        if (db.viewHS(U) < s)
        {   db.updateHS(U, s);
            JOptionPane.showMessageDialog(null, "Congratulations! New High Score :DD");
        }
    }

    class Disp extends JPanel {
        @Override
        public void paint(Graphics g) {
            g.setColor(Color.blue);
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            String str = "Well, you're dead. You might as well \n know how much "
                    + "you scored: "+score;
            g.drawString(str, 150, 50);

        }
    }
}
