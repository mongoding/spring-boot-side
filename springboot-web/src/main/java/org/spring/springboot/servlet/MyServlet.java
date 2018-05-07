package org.spring.springboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注解使用servlet 需要在Application上加入 @ServletComponentScan
 *
 * @author
 */
@WebServlet(name = "myServlet", urlPatterns = "/servlet/myServlet")
public class MyServlet extends HttpServlet {

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
        out.println("<h1>welcome this is my servlet!!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }


}