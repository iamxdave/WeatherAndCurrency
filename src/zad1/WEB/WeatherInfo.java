package zad1.WEB;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class WeatherInfo {

    String content;
    public WeatherInfo(String content) {
        this.content = content;
    }

    public String getJSONInfo() {

        JSONParser parser = new JSONParser();

        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(content);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StringBuilder weatherInfo = new StringBuilder();

        String loc = "Loc: " + object.get("name");

        String clouds = object.get("clouds").equals(0)? "Clear" : "Clouds";

        String sky = "Sky: " + clouds;

        JSONObject main = (JSONObject) object.get("main");

        String temp = "Temperature: " + String.format("%.2f", (double)main.get("temp") - 273);

        String pressure = "Pressure: " + main.get("pressure");

        String humidity = "Humidity: " + main.get("humidity");

        JSONObject wind = (JSONObject) object.get("wind");

        String speed = "Wind: " + wind.get("speed");

        weatherInfo
                .append(loc).append("\n")
                .append(sky).append("\n")
                .append(temp).append("\n")
                .append(pressure).append("\n")
                .append(humidity).append("\n")
                .append(speed).append("\n");

        return weatherInfo.toString();
    }
}
