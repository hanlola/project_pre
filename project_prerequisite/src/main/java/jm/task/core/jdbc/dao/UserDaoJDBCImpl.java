package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = Util.openConnection();
            String sql_query = "CREATE TABLE users (id bigint not null PRIMARY KEY AUTO_INCREMENT, name varchar(64), lastname varchar(64), age tinyint)";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.executeUpdate();
            Util.closeConnection(connection);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Util.openConnection();
            String sql_query = "DROP TABLE users";
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.executeUpdate();
            Util.closeConnection(connection);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.openConnection();
            String sqlQuery = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";

            preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeUserById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = Util.openConnection();
            String sqlQuery = "DELETE from users WHERE id = ?";
            preparedStatement =connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<User> getAllUsers() {
        Connection connection = null;
        Statement statement = null;
        List<User> users =new ArrayList<>();

        try{
            connection = Util.openConnection();
            String sqlQuery = "SELECT id, name, lastname, age FROM users";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                User user =new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public void cleanUsersTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = Util.openConnection();
            String sqlQuery = "TRUNCATE TABLE users";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
