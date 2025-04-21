import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {

    private String apiKey;
    private String address;
    private HttpClient client;
    private HttpRequest request;

    public ExchangeRateApi() {
        this.apiKey = "c19d9fdf00e44cd9f44a66b1";
        this.address = "https://v6.exchangerate-api.com/v6/"
            + this.apiKey + "/latest/USD";
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder()
            .uri(URI.create(this.address))
            .build();
    }

    public String makeReques() {
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
