import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        

        // Pegar a API/ fazer uma conexão HTTP 
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI end = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest get = HttpRequest.newBuilder(end).GET().build();
        HttpResponse<String> send = client.send(get,BodyHandlers.ofString());
        String body = send.body();
        

        // extrair só oq interessa (titulo, poster, classicação) [parcear]
        JsonParser parser = new JsonParser();
        List<Map<String, String>> MovieList = parser.parse(body); 
        
        // exibir e manipular os dados
        for (Map<String,String> movie : MovieList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }


    }

}
