package zad1.GUI;


import zad1.WEB.Browser;

import javax.swing.*;
import java.awt.*;

public class Window extends Display {

    private InfoPanel infoPanel;
    private Browser browser;

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    public Browser getBrowser() {
        return browser;
    }

    public Window(int width, int height, String title) {
        super(width, height, title);

        infoPanel = new InfoPanel(this);
        browser = new Browser();

        setLayout(new BorderLayout(50, 50));
        createComponents();
        pack();
    }

    public void createComponents() {
        JLabel label = new JLabel("TPO S22980", SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        add(label, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);

        add(browser, BorderLayout.SOUTH);
    }
}
