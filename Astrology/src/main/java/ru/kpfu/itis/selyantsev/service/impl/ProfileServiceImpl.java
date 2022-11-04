package ru.kpfu.itis.selyantsev.service.impl;

import ru.kpfu.itis.selyantsev.dao.DAO;
import ru.kpfu.itis.selyantsev.dao.ProfileDAO;
import ru.kpfu.itis.selyantsev.dao.impl.ProfileDAOImpl;
import ru.kpfu.itis.selyantsev.dao.impl.UserDaoImpl;
import ru.kpfu.itis.selyantsev.models.Profile;
import ru.kpfu.itis.selyantsev.models.User;
import ru.kpfu.itis.selyantsev.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {

    private final ProfileDAO profileDAO = new ProfileDAOImpl();
    private final DAO userDao = new UserDaoImpl();

    @Override
    public void delete(String loginName) {
        profileDAO.delete(loginName);
    }

    @Override
    public Profile createProfile(String loginName, String photoUrl,
                                 String profileRole, String profileHobby ) {
        User user = userDao.findByLoginName(loginName);
        String accountLoginName = user.getLogin();
        Profile profile = new Profile(
                photoUrl,
                profileRole,
                profileHobby,
                accountLoginName
        );
        return profile;
    }

    @Override
    public void save(Profile entity) {
        profileDAO.save(entity);
    }


}
