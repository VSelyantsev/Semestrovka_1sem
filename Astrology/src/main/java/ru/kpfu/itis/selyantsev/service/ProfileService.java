package ru.kpfu.itis.selyantsev.service;

import ru.kpfu.itis.selyantsev.models.Profile;

public interface ProfileService {

    void delete(String loginName);
    Profile createProfile(String loginName, String photoUrl, String profileRole, String profileHobby);

    void save(Profile entity);
}
