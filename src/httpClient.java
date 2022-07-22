import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class httpClient {
    
    public String getData(String url) {
        try{
            URI address = URI.create(url);
            var client = HttpClient.newHttpClient();
            //GET - get data of an url or uri
            var request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            //bodyHandler = creat way to read the classe

            String body = response.body();
            return body;
            //alt shift o imports all
        } catch (IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }

        

    }
}
