public class Content {
    private final String title;
    private final String Imageurl;

    public Content(String title, String Imageurl) {
        this.title = title; //object
        this.Imageurl = Imageurl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageurl() {
        // source action -> generate gatters
        return Imageurl;
    }

}
