package demo.cryptoscraper.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Service
public class CryptoPriceDataService {
    private static String apiKey = "";
    private static String CRYPTO_PRICE_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=2&convert=USD";
    @PostConstruct
        public void fetchPriceData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(CRYPTO_PRICE_URL))
                .header("X-CMC_PRO_API_KEY", apiKey)
                .header("Accept", "application/json")
               // .header("Accept-Encoding", "deflate, gzip")
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(httpResponse.body());
        int bodyLength = httpResponse.body().length();
        //System.out.print(httpResponse.body());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       String response = httpResponse.body();
        List<Post> posts = mapper.readValue(response, new TypeReference<List<Post>>() {
        });
       // System.out.println(response);
        posts.forEach(System.out::println);

    }
}
