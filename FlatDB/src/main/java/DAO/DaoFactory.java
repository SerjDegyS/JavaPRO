package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    public Connection getConnection() throws SQLException;
    public FlatDao getFlatDao(Connection connection);

}
