package ru.kpfu.itis.selyantsev.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.selyantsev.service.UserService;
import ru.kpfu.itis.selyantsev.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info("Started Login");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");

        UserService userService = new UserServiceImpl();

        if (userService.login(login, password)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("login", login);
            httpSession.setMaxInactiveInterval(60 * 60);
            if (rememberMe != null) {
                Cookie httpCookie = new Cookie("login", login);
                httpCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(httpCookie);
            }
            resp.sendRedirect("mainPage.ftl");
        } else {
            resp.sendRedirect("login.ftl");
            LOGGER.info("Incorrect!");
        }
        LOGGER.info("Authorization successful!");
    }
}
