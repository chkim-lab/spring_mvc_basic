package com.example.mvc.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/req-param")
public class RequestServlet extends HelloServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        //Database 연동

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter w = resp.getWriter();
        w.println("<html>");
        w.println("<head>");
        w.println("</head>");
        w.println("<body>");
        w.println("  <div>");
        w.println("     <p>");
        w.println("        이름: " + name + ", 나이: " + age + "세");
        w.println("     </p>");
        w.println("  </div>");
        w.println("<body>");
        w.println("</html>");



        w.println("</body>");
        w.println("</html>");
    }
}
