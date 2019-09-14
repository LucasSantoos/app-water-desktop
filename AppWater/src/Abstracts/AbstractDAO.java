package Abstracts;

import Interfaces.AcoesCrud;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

abstract public class AbstractDAO implements AcoesCrud {

    public Statement getStatement() throws SQLException {
        return Database.getconnection().createStatement();
    }

    public PreparedStatement getStatement(String sql) throws SQLException {
        return Database.getconnection().prepareStatement(sql);
    }

    public int executeUpdate(String sql, Object... args) throws SQLException {
        PreparedStatement pst = this.getStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i + 1), args[i]);
        }
        return pst.executeUpdate();
    }

    public ResultSet executeQuery(String sql, Object... args) throws SQLException {
        PreparedStatement pst = this.getStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i + 1), args[i]);
        }
        return pst.executeQuery();
    }
}
