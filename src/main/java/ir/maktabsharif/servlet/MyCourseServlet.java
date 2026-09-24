package ir.maktabsharif.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "MyCourseServlet", value = "/mycourse")
public class MyCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Session Not Found!");
            return;
        }

        String studentName = (String) session.getAttribute("studentName");
        String courseName = (String) session.getAttribute("courseName");
        BigDecimal finalPrice = (BigDecimal) session.getAttribute("finalPrice");

        req.setAttribute("studentName", studentName);
        req.setAttribute("courseName", courseName);
        req.setAttribute("finalPrice", finalPrice);

        req.getRequestDispatcher("my-course.jsp").forward(req, resp);
    }
}
