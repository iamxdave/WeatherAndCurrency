package zad1.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class InfoPanel extends JPanel {

    private final Window window;
    private final Map<String, JTextArea> areaMap = new LinkedHashMap<>();

    public InfoPanel(Window window) {
        this.window = window;

        setLayout(new GridLayout());

        areaMap.put("Weather", new JTextArea());
        areaMap.put("Currency rate", new JTextArea());
        areaMap.put("PLN rate", new JTextArea());

        for(Map.Entry<String, JTextArea> entry : areaMap.entrySet()) {
            JTextArea textField = entry.getValue();
            textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(entry.getKey()),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            textField.setEditable(false);
            add(textField);
        }
        JButton changeData = new JButton("Change data");
        changeData.addActionListener(this::changeData);
        add(changeData);
    }

    public void setData(Map<String, JTextArea> fieldMap) {
        for(Map.Entry<String, JTextArea> entry : fieldMap.entrySet()) {
            this.areaMap.get(entry.getKey()).setText(entry.getValue().getText());
        }
    }

    public void changeData(ActionEvent e) {
        new Menu(400, 250, "Menu", window);



        this.window.repaint();
    }
}
