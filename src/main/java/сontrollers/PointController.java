package сontrollers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/point")
public class PointController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(2);
    }
}

// тело запроса
//req.getReader().lines().collect(Collectors.joining(System.lineSeparator()))