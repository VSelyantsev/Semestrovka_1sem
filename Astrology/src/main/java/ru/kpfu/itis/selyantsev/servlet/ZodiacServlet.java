package ru.kpfu.itis.selyantsev.servlet;

import ru.kpfu.itis.selyantsev.service.UserService;
import ru.kpfu.itis.selyantsev.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "zodiacs", urlPatterns = "/zodiacs")
public class ZodiacServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("zodiacSigns.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String param = req.getParameter("request");
        String resultSearch = userService.search(param);
        resp.sendRedirect(resultSearch);
    }
}
