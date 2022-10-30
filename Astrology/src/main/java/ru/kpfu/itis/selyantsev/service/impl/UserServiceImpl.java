package ru.kpfu.itis.selyantsev.service.impl;

import ru.kpfu.itis.selyantsev.dao.PlanetDAO;
import ru.kpfu.itis.selyantsev.dao.ProfileDAO;
import ru.kpfu.itis.selyantsev.dao.ZodiacSignsDAO;
import ru.kpfu.itis.selyantsev.dao.impl.PlanetDaoImpl;
import ru.kpfu.itis.selyantsev.dao.impl.ProfileDAOImpl;
import ru.kpfu.itis.selyantsev.dao.impl.ZodiacSignsImpl;
import ru.kpfu.itis.selyantsev.models.Planet;
import ru.kpfu.itis.selyantsev.models.Profile;
import ru.kpfu.itis.selyantsev.models.User;
import ru.kpfu.itis.selyantsev.models.ZodiacSigns;
import ru.kpfu.itis.selyantsev.util.PasswordUtil;

import ru.kpfu.itis.selyantsev.dao.DAO;
import ru.kpfu.itis.selyantsev.dao.impl.UserDaoImpl;
import ru.kpfu.itis.selyantsev.dto.UserDTO;
import ru.kpfu.itis.selyantsev.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class UserServiceImpl implements UserService {

    private final PlanetDAO planetDAO = new PlanetDaoImpl();

    private final ZodiacSignsDAO zodiacSignsDAO = new ZodiacSignsImpl();

    private final ProfileDAO profileDAO = new ProfileDAOImpl();

    private final DAO userDao = new UserDaoImpl();


    @Override
    public void save(User entity) {
        entity.setPassword(PasswordUtil.encrypt(entity.getPassword()));
        userDao.save(entity);
    }

    @Override
    public List<UserDTO> findAll() {
        return userDao.findAll().stream()
                .map(
                        user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getLogin(), user.getEmail())
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userDao.findById(id).map(
                user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getLogin(), user.getEmail())
        );
    }

    @Override
    public UserDTO findByLogin(String login) {
        User u = userDao.findByLoginName(login);
        return new UserDTO(u.getFirstName(), u.getLastName(), u.getLogin(), u.getEmail());
    }

    @Override
    public boolean login(String loginName, String password) {
        User user = userDao.findByLoginName(loginName);
        return user.getPassword().equals(PasswordUtil.encrypt(password));
    }

    @Override
    public String search(String request) {
        String requestCondition = " ";

        List<Planet> resultPlanetList = planetDAO.findAll()
                .stream()
                .filter(planet -> planet.getPlanetName().equals(request))
                .collect(Collectors.toList());

        List<ZodiacSigns> resultZodiacList = zodiacSignsDAO.findAll()
                .stream()
                .filter(constellation -> constellation.getZodiacName().equals(request))
                .collect(Collectors.toList());

        if (!resultPlanetList.isEmpty()) {
            requestCondition = "planets.ftl";
        } else if (!resultZodiacList.isEmpty()) {
            requestCondition = "zodiacSigns.ftl";
        } else {
            requestCondition = "mainPage.ftl";
        }

        return requestCondition;
    }

    @Override
    public Profile createNullProfile(String loginName) {
        User user = userDao.findByLoginName(loginName);
        String accountLoginName = user.getLogin();
        Profile profile = new Profile(
                "null",
                "null",
                "null",
                accountLoginName
        );
        profileDAO.save(profile);
        return profile;
    }


}
