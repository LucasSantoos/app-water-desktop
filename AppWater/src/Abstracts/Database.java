package Abstracts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class Database {

    private static Connection connection;

    public static Connection getconnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/my_water",
                    "postgres",
                    "Marcilio1");
        }
        return connection;
    }
}
