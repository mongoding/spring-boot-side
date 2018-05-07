package org.spring.springboot.servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet1 extends HttpServlet {

    private static final long serialVersionUID = 8031133938454140403L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>welcome this is my servlet1!!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }


}
