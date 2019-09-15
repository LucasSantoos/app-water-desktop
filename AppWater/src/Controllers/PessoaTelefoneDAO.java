package Controllers;

import Abstracts.AbstractDAO;
import Models.Pessoa;
import Models.PessoaTelefone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PessoaTelefoneDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        PessoaTelefone pessoaTelefone = (PessoaTelefone) object;
        return super.executeUpdate(
                "INSERT INTO PESSOAS_TELEFONES (DESCRICAO, NRO_TELEFONE, "
                        + "ID_PESSOA) VALUES (?,?,?)",
                pessoaTelefone.getDescricao(),
                pessoaTelefone.getNroTelefone(),
                pessoaTelefone.getPessoa().getId()
        );
    }

    @Override
    public int update(Object object) throws SQLException {
        PessoaTelefone pessoaTelefone = (PessoaTelefone) object;
        return super.executeUpdate(
                "UPDATE PESSOAS_TELEFONES SET DESCRICAO=?, NRO_TELEFONE=?, "
                + " ID_PESSOA=? WHERE ID=?",
                pessoaTelefone.getDescricao(),
                pessoaTelefone.getNroTelefone(),
                pessoaTelefone.getPessoa().getId(),
                pessoaTelefone.getId()
        );
    }

    @Override
    public int delete(Object object) throws SQLException {
        PessoaTelefone pessoaTelefone = (PessoaTelefone) object;
        return super.executeUpdate("DELETE FROM PESSOAS_TELEFONES WHERE ID=?",
                pessoaTelefone.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS_TELEFONES WHERE ID=?",
                id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS_TELEFONES ORDER BY PESSOAS_TELEFONES.DESCRICAO");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS_TELEFONES WHERE PESSOAS_TELEFONES.DESCRICAO LIKE ? "
                + "ORDER BY PESSOAS_TELEFONES.DESCRICAO",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        PessoaTelefone pessoaTelefone = new PessoaTelefone(
                rs.getInt("ID"),
                rs.getString("DESCRICAO"),
                rs.getString("NRO_TELEFONE"),
                (Pessoa) new PessoaDAO().get(rs.getInt("ID_PESSOA")));
        return pessoaTelefone;
    }
}
