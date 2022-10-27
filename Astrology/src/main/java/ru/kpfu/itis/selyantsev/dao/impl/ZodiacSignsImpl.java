package ru.kpfu.itis.selyantsev.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.selyantsev.dao.ZodiacSignsDAO;
import ru.kpfu.itis.selyantsev.models.ZodiacSigns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static ru.kpfu.itis.selyantsev.util.PostgresConnectionUtil.getConnection;

public class ZodiacSignsImpl implements ZodiacSignsDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZodiacSignsImpl.class);

    private static Connection connection;

    private static final String SQL_INSERT_CONSTELLATION = "insert into " +
            "constellations(constellation_name, constellation_coordinates, constellation_form" +
            "values(?, ?, ?)";
    private static final String SQL_FIND_CONSTELLATION_BY_ID = "select * from constellations where id = ?";

    private static final String SQL_FIND_CONSTELLATION_BY_LOGIN_NAME = "select * " +
            "from constellations where constellation_name = ?";

    private static final String SQL_FIND_ALL_CONSTELLATIONS = "select * from constellations";

    private static final String SQL_UPDATE_CONSTELLATION_BY_ID = "update constellations set" +
            "constellation_name = ?," +
            "constellation_coordinates = ?, " +
            "constellation_form = ? " +
            "where id = ?";

    private static final String SQL_DELETE_CONSTELLATION_BY_LOGIN = "delete from " +
            "constellations where constellation_name = ?";

    private static final String SQL_DELETE_CONSTELLATION_BY_ID = "delete from " +
            "constellations where id = ?";

    private static final Function<ResultSet, Constellation> constellationMapper = row -> {
      try {
          String constellationName = row.getString("constellation_name");
          String constellationCoordinates = row.getString("constellation_coordinates");
          String constellationForm = row.getString("constellation_form");
          return new Constellation(constellationName, constellationCoordinates, constellationForm);
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    };
    @Override
    public void save(Constellation entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_CONSTELLATION)) {
            preparedStatement.setString(1, entity.getConstellationName());
            preparedStatement.setString(2, entity.getConstellationCoordinates());
            preparedStatement.setString(3, entity.getConstellationForm());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Save failed! ", e);
        }
    }

    @Override
    public Optional<Constellation> findById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CONSTELLATION_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Constellation constellation = constellationMapper.apply(resultSet);
                    return Optional.of(constellation);
                } else {
                    LOGGER.warn("Constellation does not exist");
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Constellation findByLoginName(String constellationName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CONSTELLATION_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, constellationName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) return constellationMapper.apply(resultSet);
            } catch (SQLException e) {
                LOGGER.warn("Choise is not correct ", e);
            }
        } catch (SQLException e) {
            LOGGER.warn("Illegal Argument, choose correct argument! ", e);
        }
        LOGGER.warn("Constellation does not exist");
        return null;
    }

    @Override
    public List<Constellation> findAll() {
        connection = getConnection();
        List<Constellation> resultConstellationList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_CONSTELLATIONS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next())  {
                    resultConstellationList.add(constellationMapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Table does not exist ", e);
        }
        return resultConstellationList;
    }

    @Override
    public void update(Constellation entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_CONSTELLATION_BY_ID)) {
            preparedStatement.setString(1, entity.getConstellationName());
            preparedStatement.setString(2, entity.getConstellationCoordinates());
            preparedStatement.setString(3, entity.getConstellationForm());
            preparedStatement.setLong(4, entity.getConstellationId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Planet does not exist");
        }
    }

    @Override
    public void delete(Constellation entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CONSTELLATION_BY_LOGIN)) {
            preparedStatement.setString(1, entity.getConstellationName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Constellation does not exist");
        }
    }

    @Override
    public void deleteById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CONSTELLATION_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose correct id! ", e);
        }
    }
}
