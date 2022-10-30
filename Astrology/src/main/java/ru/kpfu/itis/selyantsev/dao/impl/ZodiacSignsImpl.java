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

    private static final String SQL_INSERT_ZODIAC = "insert into " +
            "zodiac_signs(zodiac_name, zodiac_type, zodiac_element" +
            "values(?, ?, ?)";
    private static final String SQL_FIND_ZODIAC_BY_ID = "select * from zodiac_signs where id = ?";

    private static final String SQL_FIND_ZODIAC_BY_LOGIN_NAME = "select * " +
            "from zdoiac_signs where zodiac_name = ?";

    private static final String SQL_FIND_ALL_ZODIAC = "select * from zodiac_signs";

    private static final String SQL_UPDATE_ZODIAC_BY_LOGIN_NAME = "update zodiac_signs set" +
            "zodiac_name = ?," +
            "zodiac_type = ?, " +
            "zodiac_element = ? " +
            "where zodiac_name = ?";

    private static final String SQL_DELETE_ZODIAC_BY_LOGIN = "delete from " +
            "zodiac_signs where zodiac_name = ?";

    private static final String SQL_DELETE_ZODIAC_BY_ID = "delete from " +
            "zodiac_signs where id = ?";

    private static final Function<ResultSet, ZodiacSigns> zodiacSignsMapper = row -> {
      try {
          String zodiacName = row.getString("zodiac_name");
          String zodiacType = row.getString("zodiac_type");
          String zodiacElement = row.getString("zodiac_element");
          return new ZodiacSigns(zodiacName, zodiacType, zodiacElement);
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    };

    @Override
    public void save(ZodiacSigns entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ZODIAC)) {
            preparedStatement.setString(1, entity.getZodiacName());
            preparedStatement.setString(2, entity.getZodiacType());
            preparedStatement.setString(3, entity.getZodiacType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Save failed! ", e);
        }
    }

    @Override
    public Optional<ZodiacSigns> findById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ZODIAC_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ZodiacSigns zodiacSigns = zodiacSignsMapper.apply(resultSet);
                    return Optional.of(zodiacSigns);
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
    public ZodiacSigns findByLoginName(String zodiacName) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ZODIAC_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, zodiacName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) return zodiacSignsMapper.apply(resultSet);
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
    public List<ZodiacSigns> findAll() {
        connection = getConnection();
        List<ZodiacSigns> resultZodiacList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_ZODIAC)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next())  {
                    resultZodiacList.add(zodiacSignsMapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.warn("Table does not exist ", e);
        }
        return resultZodiacList;
    }

    @Override
    public void update(ZodiacSigns entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ZODIAC_BY_LOGIN_NAME)) {
            preparedStatement.setString(1, entity.getZodiacName());
            preparedStatement.setString(2, entity.getZodiacType());
            preparedStatement.setString(3, entity.getZodiacElement());
            preparedStatement.setString(4, entity.getZodiacName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Planet does not exist");
        }
    }

    @Override
    public void delete(ZodiacSigns entity) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ZODIAC_BY_LOGIN)) {
            preparedStatement.setString(1, entity.getZodiacName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Constellation does not exist");
        }
    }

    @Override
    public void deleteById(Long id) {
        connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ZODIAC_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Can't delete. Choose correct id! ", e);
        }
    }
}
