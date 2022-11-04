package ru.kpfu.itis.selyantsev.servlet;

import ru.kpfu.itis.selyantsev.service.ProfileService;
import ru.kpfu.itis.selyantsev.service.UserService;
import ru.kpfu.itis.selyantsev.service.impl.ProfileServiceImpl;
import ru.kpfu.itis.selyantsev.service.impl.UserServiceImpl;
import ru.kpfu.itis.selyantsev.models.Profile;

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
    private final ProfileService profileService = new ProfileServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String login = (String) httpSession.getAttribute("login");
        String profilePhotoUrl = "http://res.cloudinary.com/duy2v66de/image/upload/v1667519879/chpstuk9kcit3kii4zbc.png";
        String profileRole = "Not specified";
        String profileHobby = "Not specified";
        Profile profile = profileService.createProfile(login, profilePhotoUrl, profileRole, profileHobby);
        req.setAttribute("user", userService.findByLogin(login));
        req.setAttribute("profile", profile);
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

}
