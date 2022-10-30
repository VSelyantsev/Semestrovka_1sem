package ru.kpfu.itis.selyantsev.dao;

import ru.kpfu.itis.selyantsev.models.Profile;
import ru.kpfu.itis.selyantsev.repository.CrudRepository;

public interface ProfileDAO extends CrudRepository<Long, Profile> {
}
