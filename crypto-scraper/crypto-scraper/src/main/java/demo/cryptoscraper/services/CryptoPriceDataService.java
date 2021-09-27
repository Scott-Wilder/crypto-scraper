package demo.cryptoscraper.services;


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
import java.util.Map;


@Service
public class CryptoPriceDataService {
    private static String apiKey = "";
    private static String CRYPTO_PRICE_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?symbol=BTC,ETH";
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
       // System.out.print(httpResponse.body());
        Object obj = JSONValue.parse(httpResponse.body());
        if(obj.equals("price"));
        {
            System.out.println(obj.get("name"));
        }
        System.out.println(obj);




 /*for(int i = 0; i<bodyLength; i++){
            if(httpResponse.body().charAt(i) == 'n' && httpResponse.body().charAt(i+1) == 'a' && httpResponse.body().charAt(i+2) == 'm' && httpResponse.body().charAt(i+3) == 'e'){
                String name = httpResponse.body().substring(i+7, i+14);
                System.out.print("name: "+name);
            }
            if(httpResponse.body().charAt(i) == 'p' && httpResponse.body().charAt(i+1) == 'r' && httpResponse.body().charAt(i+2) == 'i' && httpResponse.body().charAt(i+3) == 'c' && httpResponse.body().charAt(i+4) == 'e'){
                String price = httpResponse.body().substring(i+7, i+15);
                System.out.println(", Price: "+price);
            }

        }*/
    }
}
