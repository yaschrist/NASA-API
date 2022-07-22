import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //make a HTTP connection and and bring the TOP 250 movies
        //create a variable
        //String url = "https://api.mocki.io/v2/549a5d8b";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        contentExtractor extractor = new contentIMDBExtractor();
        // ctrl + . = assign the statement to a new local variable
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        contentExtractor extractor = new contentNasaExtractor();
        //URI address = URI.create(url);
        
        //GET - get data of an url or uri
        //var request = HttpRequest.newBuilder(address).GET().build();
        //HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        //bodyHandler = creat way to read the classes

        //String body = response.body();

        var http = new httpClient();
        String json = http.getData(url);

        
        //System.out.println(moviesList.size());  Tamanho da lista
        //System.out.println(contentList.get(0)); ///////


        //display and manipulate the data
        //contentNasaExtractor extractor = new contentNasaExtractor();
        List<Content> conteudos = extractor.extractContent(json);
        var factory = new stickerFactory();

        for (int i = 0; i <3; i++) {
            
            Content content = conteudos.get(i);
            //String Imageurl = content.get("url"); //replaceAll
            //movie.get("image");
            
            InputStream inputStream = new URL(content.getImageurl()).openStream();
            String fileName = "output/" + content.getTitle() + ".png";

            factory.creat(inputStream, fileName);

            System.out.println("\u001b[34;1m" + content.getTitle() + "\u001b[m");
            //System.out.println(movie.get("image"));
            //System.out.println("\033[32mRating IMDb: " + content.get("imDbRating"));
            //to decorate terminal: https://www.alura.com.br/artigos/decorando-terminal-cores-emojis
            System.out.println(content.getTitle());
        }

    }
}
