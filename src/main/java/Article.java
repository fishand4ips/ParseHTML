import lombok.Getter;
import lombok.Setter;

public class Article {

    @Getter @Setter
    private String URL;

    @Getter @Setter
    private String name;

    public Article(String URL, String name) {
        this.URL = URL;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "URL='" + URL + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
