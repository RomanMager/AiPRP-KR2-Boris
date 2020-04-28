package by.bsuir.kr2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Stateless
@LocalBean
public class FileLoader {

    public File loadFile(String url) throws IOException {
        Document document = Jsoup.connect(url).get();

        // TODO: Замени путь тот, что будет релевантен для винды. Просто вставь абсолютный путь к папке 'saved_files'
        File file = new File("/Users/roman/Dev/Boris-AiPRP-KR2/saved_files/site-data.txt");
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(document.toString());
        writer.flush();
        writer.close();

        return file;
    }

}
