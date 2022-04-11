package zad1.WEB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class Currencies {
    private final Map<String, Double> currencies;

    public Currencies() {

        currencies = new HashMap<>();
        setCurrencies();

    }

    public Double getRate(String curr_code) {
        return currencies.get(curr_code);
    }

    private void setCurrencies() {
        PageOpener pageOpener = new PageOpener();
        String content = pageOpener.getContent("https://www.nbp.pl/kursy/kursya.html");

        Document doc = Jsoup.parse(content);
        Elements tr = doc.select("table.nbptable tr");

        String line;
        for(Element elem : tr) {
            line = elem.select("td.right").text();

            if(!line.isEmpty()) {
                String[] parts = line.split(" ");

                double value = Double.parseDouble(parts[0]);
                String curr = parts[1];
                double toPLN = Double.parseDouble(parts[2].replace(',', '.'));

                currencies.put(curr, value / toPLN);
            }
        }

        currencies.put("PLN", 1.0);
    }
}
