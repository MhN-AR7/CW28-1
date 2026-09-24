package ir.maktabsharif.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        String courseName = req.getParameter("courseName");
        BigDecimal coursePrice = new BigDecimal(req.getParameter("coursePrice"));
        int sessionNum = Integer.parseInt(req.getParameter("sessionNum"));

        if (sessionNum <= 0 || coursePrice.compareTo(BigDecimal.ZERO)<0){
            resp.sendError(400,"your session or price is negative");
            return;
        }

        BigDecimal totalPrice = coursePrice.multiply(new BigDecimal(sessionNum));
        BigDecimal finalPrice = totalPrice;
        int discount = 0;

        if (sessionNum > 5) {
            finalPrice = totalPrice.multiply(BigDecimal.valueOf(0.9));
            discount = 10;
        }

        req.setAttribute("studentName", studentName);
        req.setAttribute("courseName", courseName);
        req.setAttribute("coursePrice", coursePrice);
        req.setAttribute("sessionNum", sessionNum);

        req.setAttribute("totalPrice", totalPrice);

        req.setAttribute("discount", discount);

        req.setAttribute("finalPrice", finalPrice);

        Cookie cookie = new Cookie("cookieName",studentName+"123456");
        resp.addCookie(cookie);

        req.getRequestDispatcher("registration-result.jsp").forward(req, resp);

        HttpSession session = req.getSession();

        session.setAttribute("studentName", studentName);
        session.setAttribute("courseName", courseName);
        session.setAttribute("finalPrice", finalPrice);
    }
}
