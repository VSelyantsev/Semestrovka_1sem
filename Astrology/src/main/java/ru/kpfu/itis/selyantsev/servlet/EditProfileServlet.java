package ru.kpfu.itis.selyantsev.servlet;

import com.cloudinary.Cloudinary;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import ru.kpfu.itis.selyantsev.models.Profile;
import ru.kpfu.itis.selyantsev.models.User;
import ru.kpfu.itis.selyantsev.service.ProfileService;
import ru.kpfu.itis.selyantsev.service.UserService;
import ru.kpfu.itis.selyantsev.service.impl.ProfileServiceImpl;
import ru.kpfu.itis.selyantsev.service.impl.UserServiceImpl;
import ru.kpfu.itis.selyantsev.util.CloudinaryUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "editProfile", urlPatterns = "/editProfile")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class EditProfileServlet extends HttpServlet {

    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();
    private final UserService userService = new UserServiceImpl();
    private final ProfileService profileService = new ProfileServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("EditProfile.ftl");
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

        HttpSession httpSession = req.getSession();
        String loginName = (String) httpSession.getAttribute("login");
        User user = new User(
                firstName,
                lastName,
                login,
                password,
                email,
                gender
        );
        userService.update(user, loginName);


        @NotNull(message = "Please, choose avatar")
        Part part = req.getPart("file");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File file = new File("C:\\Users\\Vladislav\\Downloads" + fileName);

        Map resultMap = cloudinary.uploader().upload(file, new HashMap<>());

        String profilePhotoUrl = (String) resultMap.get("url");
        String profileRole = req.getParameter("profileRole");
        String profileHobby = req.getParameter("profileHobby");
        Profile profile = new Profile(profilePhotoUrl, profileRole, profileHobby, loginName);
        profileService.save(profile);
        resp.sendRedirect("EditProfile.ftl");
    }
}

