package zad1.GUI;

import javafx.application.Platform;
import zad1.WEB.Service;
import zad1.WEB.WeatherInfo;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InputPanel extends JPanel {

    private final Map<String, JTextField> fieldMap = new LinkedHashMap<>();
    private final Window window;
    private final Menu menu;

    public InputPanel(Menu menu, Window window) {
        this.menu = menu;
        this.window = window;

        setLayout(new GridLayout(0, 2));

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Parameter input in English"),
                BorderFactory.createEmptyBorder(40, 50, 40, 50)));

        fieldMap.put("Country", new JTextField(10));
        fieldMap.put("City", new JTextField(10));
        fieldMap.put("Currency code", new JTextField(10));

        for(Map.Entry<String, JTextField> entry : fieldMap.entrySet()) {
            JLabel label = new JLabel(entry.getKey() + ":", JLabel.LEFT);
            label.setLabelFor(entry.getValue());
            add(label);
            add(entry.getValue());
        }

        setVisible(true);
    }

    public void setWindow() {
        boolean isEmpty = false;
        for(Map.Entry<String, JTextField> entry : fieldMap.entrySet()) {
            if(entry.getValue().getText().isEmpty())
                isEmpty = true;

        }

        if(isEmpty) {
            JOptionPane.showMessageDialog(new JFrame(), "There is no such element in database", "Error Message", JOptionPane.ERROR_MESSAGE);
            menu.dispose();
        } else {



            try {
                Service s = new Service(fieldMap.get("Country").getText());
                String weatherJson = s.getWeather(fieldMap.get("City").getText());
                Double rate1 = s.getRateFor(fieldMap.get("Currency code").getText());
                Double rate2 = s.getNBPRate();

                Map<String, JTextArea> areaMap = new HashMap<>();

                WeatherInfo weatherInfo = new WeatherInfo(weatherJson);

                areaMap.put("Weather", new JTextArea(weatherInfo.getJSONInfo()));
                areaMap.put("Currency rate", new JTextArea(String.valueOf(rate1)));
                areaMap.put("PLN rate", new JTextArea(String.valueOf(rate2)));

                Platform.runLater(
                        () -> {
                            window.getBrowser().setPage("https://en.wikipedia.org/wiki/" + fieldMap.get("City").getText());
                            window.getBrowser().loadPage();
                        }
                );
                window.getInfoPanel().setData(areaMap);
                window.pack();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), "Wrong input git parameters", "Error Message", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
