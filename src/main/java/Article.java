import lombok.Getter;
import lombok.Setter;

public class Article {

    @Getter
    @Setter
    private final String URL;

    @Getter
    @Setter
    private final String NAME;

    public Article(String URL, String NAME) {
        this.URL = URL;
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "\n" + "URL = " + URL + "; name = " + NAME;
    }
}
