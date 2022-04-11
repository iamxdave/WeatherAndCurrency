package zad1.GUI;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame{

    public Display(int width, int height, String title){
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        pack();

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
