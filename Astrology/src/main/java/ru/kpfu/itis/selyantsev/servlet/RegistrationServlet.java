package ru.kpfu.itis.selyantsev.servlet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import ru.kpfu.itis.selyantsev.models.User;
import ru.kpfu.itis.selyantsev.service.UserService;
import ru.kpfu.itis.selyantsev.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {


    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        @NotNull(message = "Firstname shouldn't be empty")
        @Length(min = 4)
        @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
        String firstName = req.getParameter("firstname");

        @NotNull(message = "Lastname shouldn't be empty")
        @Length(min = 6)
        @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
        String lastName = req.getParameter("lastname");

        @NotNull(message = "Login shouldn't be empty")
        @Size(min = 4, max = 16)
        String login = req.getParameter("login");

        @Email(message = "Email should be valid!")
        String email = req.getParameter("email");

        @Length(min = 6)
        @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}")
        String password = req.getParameter("password");

        @NotNull(message = "Please, choose your gender!")
        String gender = req.getParameter("gender");

        userService.save(new User (
                firstName,
                lastName,
                login,
                password,
                email,
                gender
        ));

        resp.sendRedirect("login.ftl");
    }
}
