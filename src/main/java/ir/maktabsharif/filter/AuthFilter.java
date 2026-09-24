package ir.maktabsharif.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter("/mycourse")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if(session == null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Session Is Null");
            return;
        }
        String studentName = (String) session.getAttribute("studentName");
        if(studentName == null){
            response.sendError(HttpServletResponse.SC_FORBIDDEN,"Student Name Is Null");
            return;
        }
        filterChain.doFilter(request,response);

    }
}