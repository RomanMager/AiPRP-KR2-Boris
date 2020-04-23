package by.bsuir.kr2;

import org.jsoup.Jsoup;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/load")
public class MainController extends HttpServlet {

    @EJB
    @Inject
    private FileLoader fileLoader;

    @EJB
    @Inject
    private Parser parser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String url = req.getParameter("url");
            File file = fileLoader.loadFile(url);

            String tagData = parser.readTagContent(Jsoup.parse(file, "UTF-8"), "img");
            List<String> imgLinks = parser.readAllImgs(Jsoup.parse(file, "UTF-8"), "img");

            if (file.exists()) {
                req.setAttribute("success", "success");
                req.setAttribute("tagData", tagData);
                req.setAttribute("imgLinks", imgLinks);
            } else {
                req.setAttribute("problem", "problem");
            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
