package ru.kpfu.itis.selyantsev.dao;

import ru.kpfu.itis.selyantsev.models.Constellation;
import ru.kpfu.itis.selyantsev.models.ZodiacSigns;
import ru.kpfu.itis.selyantsev.repository.CrudRepository;

public interface ZodiacSignsDAO extends CrudRepository<Long, ZodiacSigns> {
}
