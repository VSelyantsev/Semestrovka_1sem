package ru.kpfu.itis.selyantsev.servlet;

import ru.kpfu.itis.selyantsev.dao.ProfileDAO;
import ru.kpfu.itis.selyantsev.dao.impl.ProfileDAOImpl;
import ru.kpfu.itis.selyantsev.dto.UserDTO;
import ru.kpfu.itis.selyantsev.models.User;
import ru.kpfu.itis.selyantsev.service.UserService;
import ru.kpfu.itis.selyantsev.service.impl.UserServiceImpl;
import sun.java2d.cmm.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String login = (String) httpSession.getAttribute("login");
        req.setAttribute("user", userService.findByLogin(login));
        req.setAttribute("profile", userService.createNullProfile(login));
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

}
