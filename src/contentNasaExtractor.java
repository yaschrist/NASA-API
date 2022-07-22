import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class contentNasaExtractor {
    public List<Content> extractContent (String json) {
        
        //extract only the data that interests me (title, image, rating) - parsear os dados
        //create the object to call the parser
        var parser = new jsonParser();
        List<Map<String, String>> atributteList = parser.parse(json);

        List<Content> conteudos = new ArrayList<>();

        //popular a lista
        for (Map<String, String> atributtes : atributteList) { //json key json value
            String title = atributtes.get("title");
            String Imageurl = atributtes.get("url");
            var content = new Content(title, Imageurl);

            conteudos.add(content);
        }

        return conteudos;

    }
}
