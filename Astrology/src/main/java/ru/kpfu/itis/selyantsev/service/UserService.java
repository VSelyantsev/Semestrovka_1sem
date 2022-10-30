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

    UserDTO findByLogin(String login);

    boolean login(String loginName, String password);

    String search(String pageName);

    Profile createNullProfile(String loginName);
}
