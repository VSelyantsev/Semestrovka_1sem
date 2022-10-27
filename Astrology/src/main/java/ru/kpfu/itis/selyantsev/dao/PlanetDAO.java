package ru.kpfu.itis.selyantsev.dao;

import ru.kpfu.itis.selyantsev.models.Planet;
import ru.kpfu.itis.selyantsev.repository.CrudRepository;

public interface PlanetDAO extends CrudRepository<Long, Planet> {
}
