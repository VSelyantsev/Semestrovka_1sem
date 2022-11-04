package ru.kpfu.itis.selyantsev.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.selyantsev.dao.ProfileDAO;
import ru.kpfu.itis.selyantsev.models.Profile;

import static ru.kpfu.itis.selyantsev.util.PostgresConnectionUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ProfileDAOImpl implements ProfileDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileDAOImpl.class);

    public static final String SQL_INSERT = "insert into profile(photo, profile_role, hobby, account_login_name) " +
            "values(?, ?, ?, ?)";

    public static final String SQL_FIND_BY_ID = "select * from profile where id = ?";

    public static final String SQL_FIND_BY_LOGIN_NAME = "select * from profile " +
            "where account_login_name = ?";

    public static final String SQL_FIND_ALL = "select * from profile";

    public static final String SQL_UPDATE_BY_LOGIN_NAME = "update profile set " +
            "photo = ?," +
            "profile_role = ?, " +
            "hobby = ?, " +
            "where account_login_name like ?";

    public static final String SQL_DELETE_BY_LOGIN_NAME = "delete from profile where account_login_name like ?";

    public static final String SQL_DELETE_BY_ID = "delete from profile where id = ?";
    private static Connection connection;

    private static final Function<ResultSet, Profile> profileMapper = row -> {
        try {
            String photoURL = row.getString("photo");
            String profileRole = row.getString("profile_role");
            String profileHobby = row.getString("hobby");
            String accountLoginName = row.getString("account_login_name");
            return new Profile(photoURL, profileRole, profileHobby, accountLoginName);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @Override
    public void save(Profile entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, entity.getProfilePhotoUrl());
            preparedStatement.setString(2, entity.getProfileRole());
            preparedStatement.setString(3, entity.getProfileHobby());
            preparedStatement.setString(4, entity.getAccountLoginName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Profile does not exist! ", e);
        }
    }

    @Override
    public Optional<Profile> findById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Profile profile = profileMapper.apply(resultSet);
                    return Optional.of(profile);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Profile findByLoginName(String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, loginName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()){
                    return profileMapper.apply(resultSet);
                } else return null;
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal argument! ", e);
            return null;
        }
    }

    @Override
    public List<Profile> findAll() {
        connection = getConnection();
        List<Profile> resultProfileList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    resultProfileList.add(profileMapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal Argument! ", e);
        }
        return resultProfileList;
    }

    @Override
    public void update(Profile entity, String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, entity.getProfilePhotoUrl());
            preparedStatement.setString(2, entity.getProfileRole());
            preparedStatement.setString(3, entity.getProfileHobby());
            preparedStatement.setString(4, loginName);
        } catch (SQLException e) {
            LOGGER.warn("Update is not possible! ", e);
        }
    }

    @Override
    public void delete(String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, loginName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose another name! ", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose another id! ", e);
        }
    }

}
