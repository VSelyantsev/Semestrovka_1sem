package ru.kpfu.itis.selyantsev.dao;

import ru.kpfu.itis.selyantsev.models.Article;
import ru.kpfu.itis.selyantsev.repository.CrudRepository;

public interface ArticleDAO extends CrudRepository<Long, Article> {
}
