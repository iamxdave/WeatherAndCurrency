/**
 *
 *  @author Wróbel Dawid S22980
 *
 */

package zad1;


import javafx.application.Platform;
import zad1.GUI.Window;
import zad1.WEB.Service;
import zad1.WEB.WeatherInfo;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    String apiKey = args[0];

    Service.setApiKey(apiKey);

    Service s = new Service("Poland");
    String weatherJson = s.getWeather("Warsaw");
    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();

    Window window = new Window(1400, 1000, "Weather and currency");

    WeatherInfo weatherInfo = new WeatherInfo(weatherJson);

    Map<String, JTextArea> areaMap = new LinkedHashMap<>();

    areaMap.put("Weather", new JTextArea(weatherInfo.getJSONInfo()));
    areaMap.put("Currency rate", new JTextArea(String.valueOf(rate1)));
    areaMap.put("PLN rate", new JTextArea(String.valueOf(rate2)));


    Platform.runLater(
            () -> {
              window.getBrowser().setPage("https://en.wikipedia.org/wiki/" + s.getCity());
              window.getBrowser().loadPage();
            }
    );
    window.getInfoPanel().setData(areaMap);


  }
}
