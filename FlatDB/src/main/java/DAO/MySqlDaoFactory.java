package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {

    static final String URL = "jdbc:mysql://localhost:3306/flatdb";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public FlatDao getFlatDao(Connection connection) {
        return new MySqlFlatDao(connection);
    }
}
