package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AcoesCrud {

    abstract public int add(Object object) throws SQLException;

    abstract public int update(Object object) throws SQLException;

    abstract public int delete(Object object) throws SQLException;

    abstract Object get(int id) throws SQLException;

    abstract List<Object> getList() throws SQLException;

    abstract Object createObject(ResultSet rs) throws SQLException;

}
