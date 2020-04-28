package by.bsuir.kr2;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
@LocalBean
public class Parser {

    public Map<String, String> readTagContentsMap(Document document, String tagName,
                                                  String attrKeyName, String attrKeyValue) {
        Elements elements = document.select(tagName);

        Map<String, String> tagsContent = new HashMap<>();
        elements.forEach(element -> {
            if (!element.attr(attrKeyValue).isBlank() && !element.attr(attrKeyName).isBlank()) {
                tagsContent.put(element.attr(attrKeyName), element.attr(attrKeyValue));
            }
        });

        return tagsContent;
    }
}
