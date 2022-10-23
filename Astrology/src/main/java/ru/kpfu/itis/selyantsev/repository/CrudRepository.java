package ru.kpfu.itis.selyantsev.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<ID, T> {

    void save(T entity);

    Optional<T> findById(ID id);

    T findByLoginName(String login);
    List<T> findAll();
    void update(T entity);

    void delete(T entity);

    void deleteById(ID id);
}
