import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String URL = "http:";

    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<>();
        Document document = Jsoup.connect("http://4pda.ru/").get();

        Elements h2Elements = document.getElementsByAttributeValue("class", "list-post-title");
        h2Elements.forEach(h2Element -> {
            Element aElement = h2Element.child(0);
            String link = URL + aElement.attr("href");
            String title = aElement.child(0).text();
            articleList.add(new Article(link, title));
        });

        writeInFile(String.valueOf(articleList).replace("[", "").replace("]", ""));

    }

    public static void writeInFile(String parseData) {

        final String FILENAME = "src/main/resources/FourPDA.csv";

        File file = new File(FILENAME);

        try (FileOutputStream fop = new FileOutputStream(file)) {

            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] contentInBytes = parseData.getBytes();

            fop.write(contentInBytes);
            fop.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

