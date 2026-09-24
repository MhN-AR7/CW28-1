package ir.maktabsharif.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
@WebServlet(name = "cookie", value = "/cookie")
public class CookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Cookie> cookie = Arrays.stream(req.getCookies()).filter(c-> c.getName().equals("cookieName")).findFirst();
        PrintWriter writer = resp.getWriter();
        if(cookie.isPresent()){
            writer.println(cookie.get().getValue());
        }
        else {
            writer.println("student cookie name not find");
        }


    }
}