package Controllers;

import Abstracts.AbstractDAO;
import Models.Pais;
import Models.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EstadoDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        Estado estado = (Estado) object;
        return super.executeUpdate(
                "INSERT INTO ESTADOS (DESCRICAO, ID_PAIS) "
                + "VALUES (?,?)",
                estado.getDescricao(),
                estado.getPais().getId());
    }

    @Override
    public int update(Object object) throws SQLException {
        Estado estado = (Estado) object;
        return super.executeUpdate(
                "UPDATE ESTADOS SET DESCRICAO=?, ID_PAIS=? "
                + "WHERE ID=?",
                estado.getDescricao(),
                estado.getPais().getId(),
                estado.getId()
        );
    }

    @Override
    public int delete(Object object) throws SQLException {
        Estado estado = (Estado) object;
        return super.executeUpdate("DELETE FROM ESTADOS WHERE ID=?",
                estado.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM ESTADOS WHERE ID=?",
                id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM ESTADOS ORDER BY ESTADOS.DESCRICAO");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM ESTADOS WHERE ESTADOS.DESCRICAO LIKE ? "
                + "ORDER BY ESTADOS.DESCRICAO",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        Estado estado = new Estado(
                rs.getInt("ID"),
                rs.getString("DESCRICAO"),
                (Pais) new PaisDAO().get(rs.getInt("ID_PAIS")));
        return estado;
    }
}
