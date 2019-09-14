package Controllers;

import Abstracts.AbstractDAO;
import Models.Estado;
import Models.Cidade;
import Models.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PessoaDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        Pessoa pessoa = (Pessoa) object;
        return super.executeUpdate(
                "INSERT INTO PESSOA (NOME, CPF, DT_NASC) "
                + "VALUES (?,?,?)",
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getDtNasc());
    }

    @Override
    public int update(Object object) throws SQLException {
        Pessoa pessoa = (Pessoa) object;
        return super.executeUpdate(
                "UPDATE PESSOA SET NOME=?, CPF=?, DT_NASC=? "
                + "WHERE ID=?",
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getDtNasc(),
                pessoa.getId()
        );
    }

    @Override
    public int delete(Object object) throws SQLException {
        Pessoa pessoa = (Pessoa) object;
        return super.executeUpdate("DELETE FROM PESSOA WHERE ID=?",
                pessoa.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOA WHERE ID=?",
                id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOA ORDER BY PESSOA.NOME");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(rs);
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOA WHERE PESSOA.NOME LIKE ? "
                + "ORDER BY PESSOA.NOME",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(rs);
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa(
                rs.getInt("ID"),
                rs.getString("NOME"),                
                rs.getString("CPF"),
                rs.getDate("DT_NASC").toLocalDate());
        return pessoa;
    }
}
