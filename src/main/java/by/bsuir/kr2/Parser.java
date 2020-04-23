package by.bsuir.kr2;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class Parser {

    public String readTagContent(Document document, String tagName) {
        Element img = document.select(tagName).first();
        String text = img.attr("src");

        return text;
    }

    public List<String> readAllImgs(Document document, String tagName) {
        Elements imgs = document.select(tagName);

        List<String> imgLinks = new ArrayList<>();
        imgs.forEach(img -> {
            if (!img.attr("src").isBlank()) {
                imgLinks.add(img.attr("src"));
            }

            if (!img.attr("data-src").isBlank()) {
                imgLinks.add(img.attr("data-src"));
            }
        });

        return imgLinks;
    }
}
