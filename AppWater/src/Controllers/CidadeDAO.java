package Controllers;

import Abstracts.AbstractDAO;
import Models.Estado;
import Models.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CidadeDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        Cidade cidade = (Cidade) object;
        return super.executeUpdate(
                "INSERT INTO CIDADES (DESCRICAO, ID_ESTADO) "
                + "VALUES (?,?)",
                cidade.getDescricao(),
                cidade.getEstado().getId());
    }

    @Override
    public int update(Object object) throws SQLException {
        Cidade cidade = (Cidade) object;
        return super.executeUpdate(
                "UPDATE CIDADES SET DESCRICAO=?, ID_ESTADO=? "
                + "WHERE ID=?",
                cidade.getDescricao(),
                cidade.getEstado().getId(),
                cidade.getId()
        );
    }

    @Override
    public int delete(Object object) throws SQLException {
        Cidade cidade = (Cidade) object;
        return super.executeUpdate("DELETE FROM CIDADES WHERE ID=?",
                cidade.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM CIDADES WHERE ID=?",
                id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM CIDADES ORDER BY CIDADES.DESCRICAO");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM CIDADES WHERE CIDADES.DESCRICAO LIKE ? "
                + "ORDER BY CIDADES.DESCRICAO",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        Cidade cidade = new Cidade(
                rs.getInt("ID"),
                rs.getString("DESCRICAO"),
                (Estado) new EstadoDAO().get(rs.getInt("ID_ESTADO")));
        return cidade;
    }
}
