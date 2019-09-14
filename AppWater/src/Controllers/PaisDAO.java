package Controllers;

import Abstracts.AbstractDAO;
import Models.Pais;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PaisDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        Pais pais = (Pais) object;
        return super.executeUpdate("INSERT INTO PAISES (DESCRICAO) VALUES (?)",
                pais.getDescricao());
    }

    @Override
    public int update(Object object) throws SQLException {
        Pais pais = (Pais) object;
        return super.executeUpdate(
                "UPDATE PAISES SET DESCRICAO=? WHERE ID=?",
                pais.getDescricao(),
                pais.getId());
    }

    @Override
    public int delete(Object object) throws SQLException {
        Pais pais = (Pais) object;
        return super.executeUpdate(
                "DELETE FROM PAISES WHERE ID=?",
                pais.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PAISES WHERE ID=?", id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery("SELECT * FROM PAISES ORDER BY PAISES.DESCRICAO");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PAISES "
                + "WHERE PAISES.DESCRICAO LIKE ? ORDER BY PAISES.DESCRICAO",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        return (new Pais(
                rs.getInt("ID"),
                rs.getString("DESCRICAO")));
    }
}
