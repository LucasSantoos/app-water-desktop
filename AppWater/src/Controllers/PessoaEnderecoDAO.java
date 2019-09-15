package Controllers;

import Abstracts.AbstractDAO;
import Models.Cidade;
import Models.Pessoa;
import Models.PessoaEndereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PessoaEnderecoDAO extends AbstractDAO {

    @Override
    public int add(Object object) throws SQLException {
        PessoaEndereco pessoaEndereco = (PessoaEndereco) object;
        return super.executeUpdate(
                "INSERT INTO PESSOAS_ENDERECOS (DESCRICAO, NUMERO, BAIRRO, "
                + "ID_PESSOA, ID_CIDADE) VALUES (?,?,?,?,?)",
                pessoaEndereco.getDescricao(),
                pessoaEndereco.getNumero(),
                pessoaEndereco.getBairro(),
                pessoaEndereco.getPessoa().getId(),
                pessoaEndereco.getCidade().getId()
        );
    }

    @Override
    public int update(Object object) throws SQLException {
        PessoaEndereco pessoaEndereco = (PessoaEndereco) object;
        return super.executeUpdate(
                "UPDATE PESSOAS_ENDERECOS SET DESCRICAO=?, NUMERO=?, BAIRRO=?, "
                + " ID_PESSOA=?, ID_CIDADE=? WHERE ID=?",
                pessoaEndereco.getDescricao(),
                pessoaEndereco.getNumero(),
                pessoaEndereco.getBairro(),
                pessoaEndereco.getPessoa().getId(),
                pessoaEndereco.getCidade().getId(),
                pessoaEndereco.getId()
        );
    }

    @Override
    public int delete(Object object) throws SQLException {
        PessoaEndereco pessoaEndereco = (PessoaEndereco) object;
        return super.executeUpdate("DELETE FROM PESSOAS_ENDERECOS WHERE ID=?",
                pessoaEndereco.getId());
    }

    @Override
    public Object get(int id) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS_ENDERECOS WHERE ID=?",
                id);
        return (rs.next() ? createObject(rs) : null);
    }

    @Override
    public List<Object> getList() throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS_ENDERECOS ORDER BY PESSOAS_ENDERECOS.DESCRICAO");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    public List<Object> getList(String filtro) throws SQLException {
        ResultSet rs = super.executeQuery(
                "SELECT * FROM PESSOAS_ENDERECOS WHERE PESSOAS_ENDERECOS.DESCRICAO LIKE ? "
                + "ORDER BY PESSOAS_ENDERECOS.DESCRICAO",
                "%" + filtro.toUpperCase() + "%");
        List<Object> retorno = new LinkedList<>();
        while (rs.next()) {
            retorno.add(createObject(rs));
        }
        return retorno;
    }

    @Override
    public Object createObject(ResultSet rs) throws SQLException {
        PessoaEndereco pessoaEndereco = new PessoaEndereco(
                rs.getInt("ID"),
                rs.getString("DESCRICAO"),
                rs.getString("NUMERO"),
                rs.getString("BAIRRO"),
                (Pessoa) new PessoaDAO().get(rs.getInt("ID_PESSOA")),
                (Cidade) new CidadeDAO().get(rs.getInt("ID_CIDADE")));
        return pessoaEndereco;
    }
}
