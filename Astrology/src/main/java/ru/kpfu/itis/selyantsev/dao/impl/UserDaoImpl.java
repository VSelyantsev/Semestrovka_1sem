package ru.kpfu.itis.selyantsev.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.selyantsev.dao.DAO;
import ru.kpfu.itis.selyantsev.models.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Optional;
import java.util.function.Function;

import static ru.kpfu.itis.selyantsev.util.PostgresConnectionUtil.getConnection;

public class UserDaoImpl implements DAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private static Connection connection;
    private static final String SQL_INSERT_USER = "insert into account(first_name, last_name, login_name, " +
            "password_account, email, gender)" +
            "values(?, ?, ?, ?, ?, ?)";

    private static final String SQL_FIND_BY_ID = "select * from account where id = ?";

    private static final String SQL_FIND_BY_LOGIN = "select * from account where login_name = ?";

    private static final String SQL_FIND_ALL = "select * from account";
    private static final String SQL_UPDATE_BY_ID = "update account set first_name = ?, " +
                                                                    "last_name = ?, " +
                                                                    "login_name = ? ," +
                                                                    "password_account = ?, " +
                                                                    "email = ?, " +
                                                                    "gender = ? " +
                                                                    "where id = ?";
    private static final String SQL_DELETE_BY_LOGIN = "delete from account where login_name = ? ";

    private static final String SQL_DELETE_BY_ID = "delete from account where id = ?";
    private static final Function<ResultSet, User> userMapper = row -> {
        try {
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String login = row.getString("login_name");
            String password = row.getString("password_account");
            String email = row.getString("email");
            String gender = row.getString("gender");
            return new User(firstName, lastName, login, password, email, gender);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @Override
    public void save(User entity) {

        connection = getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Save failed! ", e);
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = userMapper.apply(resultSet);
                    return Optional.of(user);
                } else {
                    LOGGER.warn("User does not exist");
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByLoginName(String login) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return userMapper.apply(resultSet);
                }
            } catch (SQLException e) {
                LOGGER.warn("Choice is not correct", e);
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal Argument, choose correct argument!", e);
        }
        LOGGER.warn("User does not exist");
        return null;
    }
    @Override
    public List<User> findAll() {

        connection = getConnection();
        List<User> resultUsersList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    resultUsersList.add(userMapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal Argument", e);
        }

        return resultUsersList;
    }

    @Override
    public void update(User entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getGender());
            preparedStatement.setLong(7, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Update is not possible", e);
        }
    }
    @Override
    public void delete(User entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_LOGIN)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose another name!", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose another id!");
        }
    }
}
