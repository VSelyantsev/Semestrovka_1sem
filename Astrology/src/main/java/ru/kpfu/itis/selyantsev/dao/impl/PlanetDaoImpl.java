package ru.kpfu.itis.selyantsev.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.selyantsev.dao.PlanetDAO;
import ru.kpfu.itis.selyantsev.models.Planet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import static ru.kpfu.itis.selyantsev.util.PostgresConnectionUtil.getConnection;


public class PlanetDaoImpl implements PlanetDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanetDaoImpl.class);

    private static Connection connection;

    private static final String SQL_INSERT_PLANET = "insert into " +
            "planets(planet_name, planet_detection, planet_distance)" +
            "values(?, ?, ?)";

    private static final String SQL_FIND_PLANET_BY_ID = "select * from planets " +
            "where id = ?";

    private static final String SQL_FIND_BY_LOGIN_NAME = "select * from planet " +
            "where planet_name = ?";

    private static final String SQL_FIND_ALL = "select * from planets";

    private static final String SQL_UPDATE_BY_LOGIN_NAME = "update planets set " +
            "planet_name = ?," +
            "planet_detection = ?," +
            "planet_distance = ?" +
            "where planet_name like ?";

    private static final String SQL_DELETE_BY_LOGIN = "delete from planet where planet_name = ?";

    private static final String SQL_DELETE_BY_ID = "delete from planet where id = ?";

    private static final Function<ResultSet, Planet> planetMapper = row -> {
        try {
            String planetName = row.getString("planet_name");
            String planetDetection = row.getString("planet_detection");
            String planetDistance = row.getString("planet_distance");
            return new Planet(planetName, planetDetection, planetDistance);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };


    @Override
    public void save(Planet entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PLANET)) {
            preparedStatement.setString(1, entity.getPlanetName());
            preparedStatement.setString(2, entity.getPlanetDetection());
            preparedStatement.setString(3, entity.getPlanetDistance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Save failed! ", e);
        }
    }

    @Override
    public Optional<Planet> findById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PLANET_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Planet planet = planetMapper.apply(resultSet);
                    return Optional.of(planet);
                } else {
                    LOGGER.warn("Planet does not exist");
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Planet findByLoginName(String planetName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, planetName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) return planetMapper.apply(resultSet);
            } catch (SQLException e) {
                LOGGER.warn("Choice is not correct ", e);
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal Argument, choose correct argument! ", e);
        }
        LOGGER.warn("Planet does not exist");
        return null;
    }

    @Override
    public List<Planet> findAll() {
        connection = getConnection();
        List<Planet> resultPlanetList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    resultPlanetList.add(planetMapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Table does not exist ", e);
        }
        return resultPlanetList;
    }

    @Override
    public void update(Planet entity, String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, entity.getPlanetName());
            preparedStatement.setString(2, entity.getPlanetDetection());
            preparedStatement.setString(3, entity.getPlanetDistance());
            preparedStatement.setString(4, loginName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Planet does not exist", e);
        }
    }

    @Override
    public void delete(String loginName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_LOGIN)) {
            preparedStatement.setString(1, loginName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Planet does not exist ", e);
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
