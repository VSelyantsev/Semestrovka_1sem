package ru.kpfu.itis.selyantsev.service.impl;

import ru.kpfu.itis.selyantsev.models.User;
import ru.kpfu.itis.selyantsev.util.PasswordUtil;

import ru.kpfu.itis.selyantsev.dao.DAO;
import ru.kpfu.itis.selyantsev.dao.impl.UserDaoImpl;
import ru.kpfu.itis.selyantsev.dto.UserDTO;
import ru.kpfu.itis.selyantsev.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class UserServiceImpl implements UserService {

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
                        user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getLogin())
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userDao.findById(id).map(
                user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getLogin())
        );
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLoginName(login);
    }

    @Override
    public boolean login(String loginName, String password) {
        User user = userDao.findByLoginName(loginName);
        return user.getPassword().equals(PasswordUtil.encrypt(password));
    }

}
