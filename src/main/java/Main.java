import api.ExchangeRateApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CurrencyConverter;
import service.CurrencyConversionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

        ExchangeRateApi exchangeRateApi = ExchangeRateApi.getInstance();

        String apiRates = exchangeRateApi.getExchangeRates();
        CurrencyConverter converter = gson.fromJson(apiRates, CurrencyConverter.class);
        CurrencyConversionService service = new CurrencyConversionService(scanner, converter);

        service.run();
    }
}
