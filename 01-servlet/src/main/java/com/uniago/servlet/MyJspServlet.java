package com.uniago.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * 使用转发方式访问 JSP
 */
@WebServlet("jsp2")
public class MyJspServlet extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 处理请求逻辑
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}
