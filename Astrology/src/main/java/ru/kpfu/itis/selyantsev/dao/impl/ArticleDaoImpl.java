package ru.kpfu.itis.selyantsev.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.selyantsev.dao.ArticleDAO;
import ru.kpfu.itis.selyantsev.models.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import static ru.kpfu.itis.selyantsev.util.PostgresConnectionUtil.getConnection;


public class ArticleDaoImpl implements ArticleDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);

    private static Connection connection;

    private static final String SQL_SAVE_ARTICLE = "insert into " +
            "articles(article_name, article_date" +
            "values(?, ?)";

    private static final String SQL_FIND_ARTICLE_BY_ID = "select * from articles" +
            "where id = ?";

    private static final String SQL_FIND_ARTICLE_BY_LOGIN_NAME = "select *  from articles" +
            "where article_name = ?";

    private static final String SQL_FIND_ALL_ARTICLES = "select * from articles";

    private static final String SQL_UPDATE_ARTICLE_BY_LOGIN_NAME = "update articles set" +
            "article_name = ?," +
            "article_date = ?," +
            "where name_author = ?";

    private static final String SQL_DELETE_BY_ID = "delete from articles " +
            "where id = ?";

    private static final String SQL_DELETE_BY_LOGIN_NAME = "delete from articles " +
            "where article_name = ?";
    private static final Function<ResultSet, Article> articleMapper = row -> {
        try {
            String articleName = row.getString("article_name");
            Date articleDate = Date.valueOf(row.getString("article_date"));
            String authorName = row.getString("name_author");
            return new Article(articleName, articleDate, authorName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };
    @Override
    public void save(Article entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_ARTICLE)) {
            preparedStatement.setString(1, entity.getArticleName());
            preparedStatement.setDate(2, (Date) entity.getArticleDate());
        } catch (SQLException e) {
            LOGGER.warn("Save failed! ", e);
        }
    }

    @Override
    public Optional<Article> findById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ARTICLE_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Article article = articleMapper.apply(resultSet);
                    return Optional.of(article);
                } else {
                    LOGGER.warn("Article does not exist!");
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Article findByLoginName(String articleName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ARTICLE_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, articleName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) return articleMapper.apply(resultSet);
            } catch (SQLException e) {
                LOGGER.warn("Choice is not correct ", e);
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal Argument, choose correct argument! ", e);
        }
        LOGGER.warn("Article does not exist");
        return null;
    }

    @Override
    public List<Article> findAll() {
        connection = getConnection();
        List<Article> resultArticleList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_ARTICLES)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    resultArticleList.add(articleMapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Table does not exist ", e);
        }
        return resultArticleList;
    }

    @Override
    public void update(Article entity, String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ARTICLE_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, entity.getArticleName());
            preparedStatement.setDate(2, (Date) entity.getArticleDate());
            preparedStatement.setString(3, loginName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Article does not exist ", e);
        }
    }

    @Override
    public void delete(String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, loginName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Article does not exist");
        }
    }

    @Override
    public void deleteById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose correct id! ", e);
        }
    }
}
