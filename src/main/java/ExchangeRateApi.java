import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {

    private static final ExchangeRateApi instance = new ExchangeRateApi();

    private final String address;
    private final HttpClient client;
    private HttpRequest request;

    private ExchangeRateApi() {
        String apiKey = "c19d9fdf00e44cd9f44a66b1";
        this.address = "https://v6.exchangerate-api.com/v6/"
            + apiKey + "/latest/USD";
        this.client = HttpClient.newHttpClient();
        initializeRequest();
    }

    private void initializeRequest() {
        this.request = HttpRequest.newBuilder()
            .uri(URI.create(this.address))
            .build();
    }

    public static ExchangeRateApi getInstance() {
        return instance;
    }

    public String getExchangeRates() {
        String json = "";
        try {
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();

        } catch (IOException | InterruptedException e) {
            System.out.println("Opps. Algo deu errado, entre em contato com o suporte.");
        }

        return json;
    }
}
