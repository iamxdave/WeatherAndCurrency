package zad1.GUI;


import java.awt.*;

public class Menu extends Display {
    private InputPanel inputPanel;
    private ButtonPanel buttonPanel;

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public Menu(int width, int height, String title, Window window) {
        super(width, height, title);

        setLayout(new BorderLayout());

        inputPanel = new InputPanel(this, window);
        buttonPanel = new ButtonPanel(this);

        createComponents();
        pack();
    }

    public void createComponents() {
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
