package ru.kpfu.itis.selyantsev.service;

import ru.kpfu.itis.selyantsev.dto.UserDTO;
import ru.kpfu.itis.selyantsev.models.Profile;
import ru.kpfu.itis.selyantsev.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User entity);

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

    User findByLogin(String login);

    void update(User entity, String loginName);

    boolean login(String loginName, String password);

    String search(String pageName);


}
