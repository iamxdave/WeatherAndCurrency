package zad1.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ButtonPanel extends JPanel implements ActionListener {

    private final ArrayList<JButton> buttonList = new ArrayList<>();
    private final Menu menu;

    public ButtonPanel(Menu menu) {
        this.menu = menu;

        setLayout(new FlowLayout());

        buttonList.add(new JButton("OK"));
        buttonList.add(new JButton("Cancel"));

        for(JButton button : buttonList) {
            button.setFocusable(false);
            button.addActionListener(this);
            add(button);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        try {
            Method m = this.getClass().getDeclaredMethod("method"+cmd);
            m.invoke(this);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    public void methodOK() {
        menu.dispose();
        menu.getInputPanel().setWindow();
    }

    public void methodCancel() {
        menu.dispose();
    }
}
