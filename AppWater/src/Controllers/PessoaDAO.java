package Controllers;

import Abstracts.AbstractDAO;
import Enums.TipoPessoa;
import Models.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PessoaDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        Pessoa pessoa = (Pessoa) object;
        return super.executeUpdate(
                "INSERT INTO PESSOAS (NOME, CPF, DT_NASC, TIPO_PESSOA) "
                + "VALUES (?,?,?,?)",
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getDtNasc(),
                pessoa.getTipoPessoa().name());
    }

    @Override
    public int update(Object object) throws SQLException {
        Pessoa pessoa = (Pessoa) object;
        return super.executeUpdate(
                "UPDATE PESSOAS SET NOME=?, CPF=?, DT_NASC=?, TIPO_PESSOA=? "
                + "WHERE ID=?",
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getDtNasc(),
                pessoa.getTipoPessoa().name(),
                pessoa.getId()
        );
    }

    @Override
    public int delete(Object object) throws SQLException {
        Pessoa pessoa = (Pessoa) object;
        return super.executeUpdate("DELETE FROM PESSOAS WHERE ID=?",
                pessoa.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS WHERE ID=?",
                id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS ORDER BY PESSOAS.NOME");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS WHERE PESSOAS.NOME LIKE ? "
                + "ORDER BY PESSOAS.NOME",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa(
                rs.getInt("ID"),
                rs.getString("NOME"),                
                rs.getString("CPF"),
                rs.getDate("DT_NASC").toLocalDate(),
                TipoPessoa.valueOf(rs.getString("TIPO_PESSOA")));
        return pessoa;
    }
}
