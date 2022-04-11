/**
 *
 *  @author Wróbel Dawid S22980
 *
 */

package zad1.WEB;

import java.util.Currency;
import java.util.Locale;

public class Service {

    private static String apiKey;

    private final String countryCode;
    private final String countryCurrency;
    private final PageOpener pageOpener;
    private final Currencies currencies;
    private String city;


    public Service(String country) {
        countryCode = getCode(country);
        countryCurrency = getCurrency(countryCode);
        pageOpener = new PageOpener();
        currencies = new Currencies();
    }

    public static void setApiKey(String apiKey) {
        Service.apiKey = apiKey;
    }

    public String getWeather(String city) {
        this.city = city;

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ',' + countryCode + apiKey;

        return pageOpener.getContent(url);
    }

    public Double getRateFor(String curr_code) {

        return currencies.getRate(curr_code)/currencies.getRate(countryCurrency);
    }

    public Double getNBPRate() {
        return currencies.getRate(countryCurrency);
    }


    public String getCode(String country) {

        for(String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            if(l.getDisplayCountry(Locale.ENGLISH).equals(country))
                return iso;
        }

        throw new IllegalArgumentException("There is no such country");
    }

    public String getCurrency(String country_code) {

        return Currency.getInstance(new Locale("", country_code)).getCurrencyCode();
    }

    public String getCity() {
        return city;
    }
}

