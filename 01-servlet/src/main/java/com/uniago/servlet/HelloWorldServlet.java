package com.uniago.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用WebServlet注解映射请求
 * 直接使用PrintWriter输出HTML内容
 */
@WebServlet("/hello2")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");
        
        // 获取PrintWriter对象
        PrintWriter out = response.getWriter();
        
        // 输出HTML内容
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("<h1>Hello, Servlet!</h1>");
        out.println("<h1>Hello, java!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        // 关闭PrintWriter
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
